package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.RequestDocuments;
import mx.edu.itspa.esgi.scse.service.RequestDocumentsServiceAPI;

@RestController
@RequestMapping(value="/resquestdocuments")
public class RequestDocumentsRestController  {
	@Autowired
	private RequestDocumentsServiceAPI requestdocumentsServiceAPI;
	
	@GetMapping("/all")
	public List<RequestDocuments> getAll() {
		return requestdocumentsServiceAPI.getAll();
	}
}
