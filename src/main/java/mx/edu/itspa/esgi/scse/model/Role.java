package mx.edu.itspa.esgi.scse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Role {

	@Id
	@Column
	private Long id;

	@Column
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String name, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String toString() {// overriding the toString() method
		return this.getName();
	}
}
