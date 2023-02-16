package mx.edu.itspa.esgi.scse.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comments")
public class Comment {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="El campo contraseña es obligatorio")
	private String comment;
	
	private String updated;
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "request_id", referencedColumnName = "id")
	@JsonBackReference
	private Request request;

	/**
	 * @param id
	 * @param user
	 * @param request
	 * @param comment
	 * @param updated
	 */
	public Comment(Integer id, User user, Request request, String comment, String updated) {
		super();
		this.id = id;
		this.user = user;
		this.request = request;
		this.comment = comment;
		this.updated = updated;
	}

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
