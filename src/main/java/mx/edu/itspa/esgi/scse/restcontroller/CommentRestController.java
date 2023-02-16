package mx.edu.itspa.esgi.scse.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itspa.esgi.scse.model.Comment;
import mx.edu.itspa.esgi.scse.service.CommentServiceAPI;

@RestController
@RequestMapping(value="/comment")
public class CommentRestController {
	@Autowired
	private CommentServiceAPI commentServiceAPI;
	
	@GetMapping("/all")
	public List<Comment> getAll() {
		return commentServiceAPI.getAll();
	}
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> save(@RequestBody Comment comment) {
		Comment persistedComment = commentServiceAPI.save(comment);
        return ResponseEntity.status(HttpStatus.OK)
				.body(persistedComment);
    }
}
