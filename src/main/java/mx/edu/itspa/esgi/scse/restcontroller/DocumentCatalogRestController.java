package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.DocumentCatalog;
import mx.edu.itspa.esgi.scse.service.DocumentCatalogServiceAPI;

@RestController
@RequestMapping(value="/document")
public class DocumentCatalogRestController {
	@Autowired
	private DocumentCatalogServiceAPI documentServiceAPI;
	
	@GetMapping("/all")
	public List<DocumentCatalog> getAll() {
		return documentServiceAPI.getAll();
	}
}
