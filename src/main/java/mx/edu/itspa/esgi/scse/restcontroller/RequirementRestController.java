package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Requirement;
import mx.edu.itspa.esgi.scse.service.RequirementServiceAPI;

@RestController
@RequestMapping(value="/requirement")
public class RequirementRestController {
	@Autowired
	private RequirementServiceAPI requirementServiceAPI;
	
	@GetMapping("/all")
	public List<Requirement> getAll() {
		return requirementServiceAPI.getAll();
	}
}
