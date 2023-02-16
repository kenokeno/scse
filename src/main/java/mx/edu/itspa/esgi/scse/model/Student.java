package mx.edu.itspa.esgi.scse.model;

public class Student extends Person{
	private String no_ctrl;
	private Integer carrera;
	private Integer semestre;
	private String estatus;
	private Tutor tutor;
	
	public String getNo_ctrl() {
		return no_ctrl;
	}
	public void setNo_ctrl(String no_ctrl) {
		this.no_ctrl = no_ctrl;
	}
	public Integer getCarrera() {
		return carrera;
	}
	public void setCarrera(Integer carrera) {
		this.carrera = carrera;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
}
