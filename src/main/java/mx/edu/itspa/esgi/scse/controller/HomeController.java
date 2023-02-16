package mx.edu.itspa.esgi.scse.controller;

import javax.servlet.http.HttpSession;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import mx.edu.itspa.esgi.scse.service.DepartmentServiceAPI;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	//@Autowired
	//private DepartmentServiceAPI departmentServiceAPI;
	
	@GetMapping("/")
	public String init(Model model, HttpSession session) {
		/*User user = (User)session.getAttribute("user");
		Department department = user.getDepartment(); //departmentServiceAPI.findByUser(user.getId());
		model.addAttribute("department", department);
		user.setDepartment(department);*/
		model.addAttribute("pageTitle", "Tablero");
		return "home/index";
	}
}
