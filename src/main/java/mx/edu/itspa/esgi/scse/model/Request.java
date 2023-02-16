package mx.edu.itspa.esgi.scse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "request")
public class Request implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	/* NO PUEDO BORRARLO, LO REQUIERO PARA ENVIAR LA INFORMACIÓN A LA APLICACIÓN MOVIL */
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "service_id")
	@JsonManagedReference
	private Service service;

	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private Status status;

	private String created;

	private String updated;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "request_id")
	private List<Comment> comments;

	@OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<RequestDocuments> requestdocuments = new ArrayList<>();

	/**
	 * @param id
	 * @param user
	 * @param service
	 * @param status
	 * @param created
	 * @param updated
	 */
	//public Request(Integer id, User user, Service service, Status status, String created, String updated) {
	public Request(Integer id, User user, Service service, Status status, String created, String updated) {
		super();
		this.id = id;
		this.user = user;
		this.service = service;
		this.status = status;
		this.created = created;
		this.updated = updated;
		this.requestdocuments = this.getRequestdocuments();
	}

	/**
	 * 
	 */
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public List<RequestDocuments> getRequestdocuments() {
		return requestdocuments;
	}

	public void setRequestdocuments(List<RequestDocuments> requestdocuments) {
		this.requestdocuments = requestdocuments;
	}
	
	/*
	public void addDocument(DocumentCatalog document) {
        RequestDocumentsRepository requestDocuments = new RequestDocumentsRepository(this, document);
        documents.add(requestDocuments);
        //document.getRequest().add(requestDocuments);
    }*/
 /*
    public void removeDocument(DocumentCatalog document) {
        for (Iterator<RequestDocumentsRepository> iterator = documents.iterator();
             iterator.hasNext(); ) {
        	RequestDocumentsRepository requestDocuments = iterator.next();
 
            if (requestDocuments.getRequest().equals(this) &&
            		requestDocuments.getDocument().equals(document)) {
                iterator.remove();
                //requestDocuments.getDocument().getRequest().remove(requestDocuments);
                requestDocuments.setRequest(null);
                requestDocuments.setDocument(null);
            }
        }
    }*/
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Request request = (Request) o;
        return Objects.equals(id, request.id);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    /**
	 * @param id
	 * @param user
	 * @param service
	 * @param status
	 * @param created
	 * @param updated
	 */
    @Override
    public String toString() {
        return "Request [id=" + id 
        		+ ", user="+ user.getUsername() 
        		+ ", service= "+status.getService().getName()
        		+", status= "+ status 
        		+ ", created= "+ created
        		+ ", updated = "+updated+"]";
    }
}
