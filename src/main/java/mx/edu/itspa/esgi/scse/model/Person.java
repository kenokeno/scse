package mx.edu.itspa.esgi.scse.model;

public class Person {
	private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
}
