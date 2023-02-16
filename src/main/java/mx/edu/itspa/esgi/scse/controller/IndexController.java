package mx.edu.itspa.esgi.scse.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController{

    @RequestMapping(value = "/403")
    public String error403(Model model) {
    	model.addAttribute("error", "Página no autorizada");
    	return "home/index";
    }
    
    @RequestMapping(value = "/404")
    public String error404(Model model) {
    	model.addAttribute("error", "Recurso no encontrado");
    	return "home/index";
    }
    
    @RequestMapping(value = "/error")
    public String error(Model model) {
    	model.addAttribute("error", "Recurso no encontrado");
    	return "home/index";
    }

    public String getErrorPath() {
        return "/403";
    }
}
