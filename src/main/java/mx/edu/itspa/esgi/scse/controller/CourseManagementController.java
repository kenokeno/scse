package mx.edu.itspa.esgi.scse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.itspa.esgi.scse.commons.ReporteToPdf;
import mx.edu.itspa.esgi.scse.dto.CourseManagementReportDTO;
import mx.edu.itspa.esgi.scse.model.CourseManagementReportType;
import mx.edu.itspa.esgi.scse.model.Degrees;
import mx.edu.itspa.esgi.scse.model.Roles;
import mx.edu.itspa.esgi.scse.model.User;

@Controller
@RequestMapping(value = "/cmreport")
public class CourseManagementController {
	private String path_coure_management_report = "WEB-INF/classes/static/reports/course_management/";
	
	@GetMapping("/")
	public String schoolTrajectory(Model model) {
		model.addAttribute("reports", CourseManagementReportType.values());
		model.addAttribute("courseManagementReport", new CourseManagementReportDTO());
		model.addAttribute("pageTitle", "Reportes de Gestión del Cursor");
		return "coursemanagement/reports";
	}

	@PostMapping("/reports")
	public String showCourseManagementReport(@ModelAttribute("courseManagementReport") CourseManagementReportDTO report,
			Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {		
		System.out.println("Imprimiendo Reporte de Gestión del Curso...");
		
		User user = (User) session.getAttribute("user");
		Map<String, Object> parameters = configurarParametros(user);
		ServletContext cntx = request.getServletContext();
		
		System.out.println("Report: " + report.getReport());
		ReporteToPdf.generarPdf(path_coure_management_report + report.getReport(), parameters, response, cntx);
		
		request.getSession().setAttribute("user", user);
		model.addAttribute("pageTitle", "Reporte " + report.getReport());
		return "reports/reportesPdf";
	}

	private Map<String, Object> configurarParametros(User user) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (user.isTeacher()) {
			parameters.put("docente", Integer.parseInt(user.getUsername()));
		} else if (user.isHeadOfDivision()) {
			Integer carrer = Degrees.valueOfDepartment(user.getDeparmentByRole(Roles.HEAD_DIVISION.getValue()).getName()).getId();
			parameters.put("carrera", carrer);
		}
		parameters.put("periodo", "2022-02");

		return parameters;
	}
}
