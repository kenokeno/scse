package mx.edu.itspa.esgi.scse.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "services")
public class Service implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String cost;
	
	private String updated;
	
	private String code;
	
	/* NO PUEDO BORRARLO, LO REQUIERO PARA ENVIAR LA INFORMACIÓN A LA APLICACIÓN MOVIL */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "service_id")
	@JsonBackReference
    private Set<Request> requests;
	
	@ManyToMany(cascade = {CascadeType.ALL})  
	@JoinTable(name = "service_documents",   
	joinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"),   
	inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id")) 
	private Set<DocumentCatalog> DocumentCatalogs;
	
	// Unidirectional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "service_id")
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
    private Set<Status> status;

    @ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})  
	@JoinTable(name = "service_requirements",   
	joinColumns = @JoinColumn(name = "service_id"),   
	inverseJoinColumns = @JoinColumn(name = "requirement_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Set<Requirement> requirements = new HashSet<Requirement>();
    
	public Service(Integer id, String name, String cost, String updated, String code, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.updated = updated;
		this.code = code;
		this.department = department;
	}
	
	public Service() {
		super();
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/*
	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}*/

	/*
	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}*/

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	public Set<DocumentCatalog> getDocuments() {
		return DocumentCatalogs;
	}

	public void setDocuments(Set<DocumentCatalog> documentCatalogs) {
		DocumentCatalogs = documentCatalogs;
	}

	public Set<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(Set<Requirement> requirements) {
		this.requirements = requirements;
	}

	public Department getDeparment() {
		return department;
	}

	public void setDeparment(Department department) {
		this.department = department;
	}

	public Set<Status> getStatus() {
		return status;
	}

	public void setStatus(Set<Status> status) {
		this.status = status;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Service service = (Service) o;
        return Objects.equals(id, service.id);
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
        return "Service [id=" + id 
        		+ ", name="+name 
        		+ ", cost= "+cost
        		+", updated= "+ updated 
        		+ ", code= "+ code
        		+ ", departmetn = "+department.getName()+"]";
    }
}
