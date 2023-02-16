package mx.edu.itspa.esgi.scse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.edu.itspa.esgi.scse.commons.ReporteToPdf;
import mx.edu.itspa.esgi.scse.commons.WSConsume;
import mx.edu.itspa.esgi.scse.dto.SchoolarTrajectoryReportDTO;
import mx.edu.itspa.esgi.scse.model.Degrees;
import mx.edu.itspa.esgi.scse.model.Roles;
import mx.edu.itspa.esgi.scse.model.SchoolarTrajectoryReportType;
import mx.edu.itspa.esgi.scse.model.Teacher;
import mx.edu.itspa.esgi.scse.model.User;
import mx.edu.itspa.esgi.scse.model.WebServices;

@Controller
@RequestMapping(value="/streport")
public class ReportsController {
	private SchoolarTrajectoryReportDTO schoolarTrajectoryReportDTO;
	
	@GetMapping("/")
	public String schoolTrajectory(Model model, HttpSession session) {
		SchoolarTrajectoryReportDTO schoolarTrajectoryReport= new SchoolarTrajectoryReportDTO();
		
		User user = (User)session.getAttribute("user");
		
		if(user.isTutor()) {
			schoolarTrajectoryReport.setTutor(Integer.parseInt(user.getUsername()));
		} else if(user.isHeadOfDivision()){
			Integer carrer = Degrees.valueOfDepartment(user.getDeparmentByRole(Roles.HEAD_DIVISION.getValue()).getName()).getId();
			schoolarTrajectoryReport.setCareer(carrer);
			model.addAttribute("tutors", getTutorsByCarrer(carrer));			
		}
		
		this.schoolarTrajectoryReportDTO = schoolarTrajectoryReport;
		
		model.addAttribute("reports", SchoolarTrajectoryReportType.values());
		if(!user.isHeadOfDivision())model.addAttribute("tutors", getTutors());		
		model.addAttribute("careers", Degrees.values());
		model.addAttribute("schoolarTrajectoryReport", schoolarTrajectoryReport);
		model.addAttribute("pageTitle", "Reportes de Trayectoria Escolar");
		return "tutorship/reports";
	}
	
	@PostMapping("/reports")
	public String showSchoolTrajectoryReport(@ModelAttribute("schoolarTrajectoryReport") SchoolarTrajectoryReportDTO report,
			Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String path_schoolar_trajetory_report = "WEB-INF/classes/static/reports/trayectoria_escolar/";
		System.out.println("Imprimiendo Reporte de Trayectoria Escolar...");
		
		if(report.getTutor()==null)report.setTutor(this.schoolarTrajectoryReportDTO.getTutor());
		if(report.getCareer()==null)report.setCareer(this.schoolarTrajectoryReportDTO.getCareer());
		
		User user = (User)session.getAttribute("user");
		Map<String, Object> parameters = configurarParametros(report);
		ServletContext cntx = request.getServletContext();
		
		System.out.println("Report: " + report.getReport());
		ReporteToPdf.generarPdf(path_schoolar_trajetory_report+report.getReport(), parameters, response, cntx);		
		
		request.getSession().setAttribute("user", user);
		model.addAttribute("pageTitle", "Reporte " + report.getReport());
		return "tutorship/reportsST/reportesPdf";
	}
	
	private ArrayList<Teacher> getTutors(){
		ArrayList<Teacher> tutors = new ArrayList<Teacher>();
		ObjectMapper obj = new ObjectMapper();
		try {
			List<Teacher> lt = WSConsume.getAll(WebServices.TEACHER_TUTORS.getValue(), new ArrayList<Teacher>());//agregarmos /services/ si se corre el servicio web en tomcat instalado y no en el predefinido (que no se como configurarlo)
			for(int i=0;i<lt.size();i++) {
				Teacher teacher = obj.readValue(obj.writeValueAsString(lt.get(i)),Teacher.class);
				tutors.add(teacher);
			}
		}catch(Exception e) {
			System.out.print("Error: " + e.getMessage());
		}
		return tutors;
	}
	
	private ArrayList<Teacher> getTutorsByCarrer(Integer carrer){
		ArrayList<Teacher> tutors = new ArrayList<Teacher>();
		ObjectMapper obj = new ObjectMapper();
		try {
			List<Teacher> lt = WSConsume.getAll(WebServices.TEACHER_TUTORS_BY_CARRER.getValue()+carrer, new ArrayList<Teacher>());//agregarmos /services/ si se corre el servicio web en tomcat instalado y no en el predefinido (que no se como configurarlo)
			for(int i=0;i<lt.size();i++) {
				Teacher teacher = obj.readValue(obj.writeValueAsString(lt.get(i)),Teacher.class);
				tutors.add(teacher);
			}
		}catch(Exception e) {
			System.out.print("Error: " + e.getMessage());
		}
		return tutors;
	}
	
	private Map<String, Object> configurarParametros(SchoolarTrajectoryReportDTO report){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tutor", report.getTutor());
		parameters.put("carrera", report.getCareer());
		parameters.put("tutorado", null);
		parameters.put("periodo", "2022-02");
		
		return parameters;
	}
}
