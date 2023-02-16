package mx.edu.itspa.esgi.scse.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull(message="El campo usuario es obligatorio.")
	@Size(min=2, max=30, message="El campo usuario debe ser mayor entre 2 y 9 caracteres.")
	@Pattern(regexp = "[a-zA-Z0-9]+", message="El campo usuario solo puede tener letras mayúsculas o números.")
	@Column(name = "username")
	private String username;
	
	@NotNull(message="El campo contraseña es obligatorio")
	@Size(min=2, max=30, message="El campo contraseña debe ser mayor a 2 caracteres.")
	@Pattern(regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{2,8}$", message="La contraseña debe tener de 2 a 8 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula. NO puede tener otros símbolos.")
	@Column(name = "password")
	private String password;
	
	@Column(name = "rfid")
	private String rfid;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Request> requests;
	 
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
	},
			fetch = FetchType.EAGER)
	@JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id")}
    )
	private List<Role> roles;

	public User(Integer id, String username, String password, String rfid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rfid = rfid;	
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<String> getNameRoles(){
		List<String> roles = getRoles().stream().map(role->role.getName()).collect(Collectors.toList());
		return roles;
	}
	
	public Department getDeparmentByRole(String role) {
		Role r = roles.stream().filter(item -> role.equalsIgnoreCase(item.getName()))
				.findAny().orElse(null);
		return r.getDepartment();		
	}
	
	public Boolean isAcademicSubditector() {
		return roles.stream().filter(role->role.getName().equalsIgnoreCase(Roles.ACADEMIC_SUBDIRECTOR.getValue())).count()!=0;
	}
	
	public Boolean isHeadOfDivision() {
		return roles.stream().filter(role->role.getName().equalsIgnoreCase(Roles.HEAD_DIVISION.getValue())).count()!=0;
	}
	
	public Boolean isTutor() {
		return roles.stream().filter(role->role.getName().equalsIgnoreCase(Roles.TUTOR.getValue())).count()!=0;
	}
	
	public Boolean isTeacher() {
		return roles.stream().filter(role->role.getName().equalsIgnoreCase(Roles.TEACHER.getValue())).count()!=0;
	}
}
