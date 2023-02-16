package mx.edu.itspa.esgi.scse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("pageTitle", "Ecosistema Software del ITSPA");
		return "login/index";
	}
}
