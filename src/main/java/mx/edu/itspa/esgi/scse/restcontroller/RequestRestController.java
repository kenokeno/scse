package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Request;
import mx.edu.itspa.esgi.scse.service.CommentServiceAPI;
import mx.edu.itspa.esgi.scse.service.RequestDocumentsServiceAPI;
import mx.edu.itspa.esgi.scse.service.RequestServiceAPI;

@RestController
@RequestMapping(value="/request")
public class RequestRestController {
	@Autowired
	private RequestServiceAPI requestServiceAPI;
	
	@Autowired
	private RequestDocumentsServiceAPI requestDocumentsServiceAPI;
	
	@Autowired
	private CommentServiceAPI commentServiceAPI;
	
	@GetMapping("/all")
	public List<Request> getAll() {
		return requestServiceAPI.getAll();
	}
	
	@GetMapping("/get/{clave}")
	public List<Request> getByUser(@PathVariable(name="clave") String clave) {
		List<Request> r = requestServiceAPI.findByUser(clave);
		List<Request> requests =new ArrayList<Request>();
		if(r!=null && !r.isEmpty()) {
			requests = r.stream().map(request -> {
				Request solicitud = request;
				solicitud.setRequestdocuments(requestDocumentsServiceAPI.findByRequest(request.getId()));
				solicitud.setComments(commentServiceAPI.findByRequest(request.getId()));
				return solicitud;
			}).collect(Collectors.toList());
		}		
		return requests;
	}
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Request> save(@RequestBody Request request) {
		Request persistedRequest = requestServiceAPI.save(request);
        return ResponseEntity.status(HttpStatus.OK)
				.body(persistedRequest);
    }
}
