package mx.edu.itspa.esgi.scse.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "requirements")
public class Requirement {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	mappedBy = "requirements")
	@JsonIgnore
	private Set<Service> services = new HashSet<Service>();

	/**
	 * @param id
	 * @param services
	 * @param description
	 */
	public Requirement(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	/**
	 * 
	 */
	public Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Requirement requirement = (Requirement) o;
        return Objects.equals(id, requirement.id);
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
        		+ ", description="+ description;
    }
}
