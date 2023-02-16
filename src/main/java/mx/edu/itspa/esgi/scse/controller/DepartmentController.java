package mx.edu.itspa.esgi.scse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.itspa.esgi.scse.model.Comment;
import mx.edu.itspa.esgi.scse.model.Request;
import mx.edu.itspa.esgi.scse.model.RequestDocuments;
import mx.edu.itspa.esgi.scse.model.User;
import mx.edu.itspa.esgi.scse.service.FileServiceAPI;
import mx.edu.itspa.esgi.scse.service.RequestDocumentsServiceAPI;
import mx.edu.itspa.esgi.scse.service.RequestServiceAPI;
import mx.edu.itspa.esgi.scse.wrapper.CommentForm;
import mx.edu.itspa.esgi.scse.service.CommentServiceAPI;

@Controller
@RequestMapping(value="/department")
public class DepartmentController {
	//@Autowired
	//private DepartmentServiceAPI departmentServiceAPI;
	
	@Autowired
	private RequestServiceAPI requestServiceAPI;
	
	@Autowired
	private RequestDocumentsServiceAPI requestDocumentsServiceAPI;
	
	@Autowired
	private FileServiceAPI fileServiceAPI;
	
	@Autowired
	private CommentServiceAPI commentServiceAPI;
	
	@GetMapping("/request/list")
	public String listRequest(Model model, HttpSession session) {
		//User user = (User)session.getAttribute("user");
		List<Request> requests = requestServiceAPI.findByDepartment(1);//user.getDepartment().getId());
		model.addAttribute("requests", requests);
		model.addAttribute("pageTitle", "Solicitudes");
		return "request/index";
	}
	
	@GetMapping("/request/get/{id}")
	public String showRequest(@PathVariable String id, Model model) {
		Request request= requestServiceAPI.get(Integer.parseInt(id));
		List<RequestDocuments> requestDocuments = requestDocumentsServiceAPI.findByRequest(request.getId());
		request.setRequestdocuments(requestDocuments);
		model.addAttribute("request", request);
		CommentForm commentForm = new CommentForm();
		commentForm.setRequestId(request.getId());
		model.addAttribute("commentForm", commentForm);
		model.addAttribute("pageTitle", "Información de la Solicitud");
		return "request/detail";
	}
	
	@GetMapping("/request/get/files/uploads/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) throws Exception {
		Resource resource = fileServiceAPI.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	@PostMapping("/request/save")
	public String submitFormRequest(@ModelAttribute("request") Request r,Model model, HttpServletRequest request) {
		Request req = requestServiceAPI.get(r.getId());
		
		req.setUpdated(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		req.setStatus(r.getStatus());
		requestServiceAPI.save(req);
		return "redirect:/department/request/list";	    
	}
	
	@PostMapping("/request/comment/save")
	public String submitFormComment(@ModelAttribute("commentForm") CommentForm commentForm,Model model, HttpServletRequest request, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Comment comment = new Comment();
		comment.setUser(user);
		Request req = requestServiceAPI.get(commentForm.getRequestId());
		comment.setComment(commentForm.getComment());
		comment.setUpdated(new SimpleDateFormat("dd/MM/YYYY hh:mm:ss").format(new Date()));
		comment.setRequest(req);
		commentServiceAPI.save(comment);
		
		List<RequestDocuments> requestDocuments = requestDocumentsServiceAPI.findByRequest(req.getId());
		req.setRequestdocuments(requestDocuments);
		model.addAttribute("request", req);
		commentForm = new CommentForm();
		commentForm.setRequestId(req.getId());
		model.addAttribute("commentForm", commentForm);
		return "redirect:/department/request/get/"+req.getId();	    
	}
}
