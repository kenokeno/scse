package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Department;
import mx.edu.itspa.esgi.scse.service.DepartmentServiceAPI;

@RestController
@RequestMapping(value="/department")
public class DepartmentRestController {
	@Autowired
	private DepartmentServiceAPI departmentServiceAPI;
	
	@GetMapping("/all")
	public List<Department> getAll() {
		return departmentServiceAPI.getAll();
	}
}
