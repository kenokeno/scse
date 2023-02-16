package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.User;
import mx.edu.itspa.esgi.scse.service.UsuarioServiceAPI;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioRestController {
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;
	
	@GetMapping("/all")
	public List<User> getAll() {
		return usuarioServiceAPI.getAll();
	}
	
	@GetMapping("/{user}")
	//@PostMapping("/session")
	//@RequestMapping (value = "/sccgii/usuario/{id}/{clave}", method = RequestMethod.GET, produces = "application/json")
	//public User getByIdAndClave(@RequestParam(name = "id") Integer id, @RequestParam(name = "clave") Integer clave) {
	public User getByUsernameAndPassword(@PathVariable(name = "user") User user) {
		return usuarioServiceAPI.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/login")
	public User getByClaveAndPassword(@RequestParam(name = "user") User user) {
		return usuarioServiceAPI.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
