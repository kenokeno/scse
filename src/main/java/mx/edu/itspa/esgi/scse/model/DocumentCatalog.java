package mx.edu.itspa.esgi.scse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class DocumentCatalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	
	@OneToMany(mappedBy = "documentCatalog", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RequestDocuments> requestdocuments = new ArrayList<>();

	/**
	 * @param id
	 * @param name
	 */
	public DocumentCatalog(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 */
	public DocumentCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public List<RequestDocumentsRepository> getRequest() {
		return request;
	}

	public void setRequest(List<RequestDocumentsRepository> request) {
		this.request = request;
	}*/

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentCatalog documentCatalog = (DocumentCatalog) o;
        return Objects.equals(name, documentCatalog.name);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    public String toString() {
        return "DocumentCatalog [id=" + id + ", name=" + name + "]";
    }
}
