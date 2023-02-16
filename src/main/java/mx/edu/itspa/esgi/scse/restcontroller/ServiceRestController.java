package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Service;
import mx.edu.itspa.esgi.scse.service.ServiceServiceAPI;

@RestController
@RequestMapping(value="/service")
public class ServiceRestController {
	@Autowired
	private ServiceServiceAPI serviceServiceAPI;
	
	@GetMapping("/all")
	public List<Service> getAll() {
		return serviceServiceAPI.getAll();
	}
}
