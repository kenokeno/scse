package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Status;
import mx.edu.itspa.esgi.scse.service.StatusServiceAPI;

@RestController
@RequestMapping(value="/status")
public class StatusRestController {
	@Autowired
	private StatusServiceAPI statusServiceAPI;

	@GetMapping("/all")
	public List<Status> getAll() {
		return statusServiceAPI.getAll();
	}
}
