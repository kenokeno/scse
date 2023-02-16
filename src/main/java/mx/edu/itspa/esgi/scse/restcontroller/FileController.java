package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import mx.edu.itspa.esgi.scse.model.DocumentCatalog;
import mx.edu.itspa.esgi.scse.model.File;
import mx.edu.itspa.esgi.scse.model.Request;
import mx.edu.itspa.esgi.scse.model.RequestDocuments;
import mx.edu.itspa.esgi.scse.model.Response;
import mx.edu.itspa.esgi.scse.model.Service;
import mx.edu.itspa.esgi.scse.service.DocumentCatalogServiceAPI;
import mx.edu.itspa.esgi.scse.service.FileServiceAPI;
import mx.edu.itspa.esgi.scse.service.RequestServiceAPI;

@RestController
@RequestMapping("/files")
public class FileController {
	@Autowired
	private FileServiceAPI fileServiceAPI;
	
	@Autowired
	private RequestServiceAPI requestServiceAPI;
	
	@Autowired
	private DocumentCatalogServiceAPI documentServiceAPI;

	@PostMapping("/upload")
	public ResponseEntity<Response> uploadFiles(@RequestParam("files") List<MultipartFile> files) throws Exception {
		fileServiceAPI.save(files);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response("Los archivos fueron cargados correctamente al servidor"));
	}
	
	@PostMapping("/upload/{requestId}/{documentId}")
	public ResponseEntity<Request> uploadFiles(@RequestParam("file") MultipartFile file, 
			@PathVariable(name="requestId") Integer requestId,
			@PathVariable(name="documentId") Integer documentId) throws Exception {
		fileServiceAPI.save(file);
		Request request = requestServiceAPI.get(requestId);
		DocumentCatalog documentCatalog = documentServiceAPI.get(documentId);
		request.getRequestdocuments().add(new RequestDocuments(request, documentCatalog, "uploads/"+file.getOriginalFilename()));
		requestServiceAPI.save(request);
		Service service = request.getService();
		request.setService(service);
		return ResponseEntity.status(HttpStatus.OK)
				.body(request);
	}

	@GetMapping("/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) throws Exception {
		Resource resource = fileServiceAPI.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<File>> getAllFiles() throws Exception {
		List<File> files = fileServiceAPI.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
			
			return new File(filename, url);
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
}
