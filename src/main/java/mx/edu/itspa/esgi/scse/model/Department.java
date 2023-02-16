package mx.edu.itspa.esgi.scse.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "departments")
public class Department {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
    private Set<Role> roles;

	/**
	 * @param id
	 * @param name
	 */
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 */
	public Department() {
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

	public Set<Role> getRols() {
		return roles;
	}

	public void setUsers(Set<Role> roles) {
		this.roles = roles;
	}
}
