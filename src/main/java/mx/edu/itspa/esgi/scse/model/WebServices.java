package mx.edu.itspa.esgi.scse.model;

public enum WebServices {
	TEACHER_ALL("http://localhost:8080/sccgii/docente/all"),
	STUDENT_ALL("http://localhost:8080/sccgii/estudiante/all"),
	TEACHER_BY_KEY("http://192.168.14.76:8080/sccgii/docente/"),
	STUDENT_BY_CONTROL_NUMBER("http://192.168.14.76:8080/sccgii/estudiante/"),
	TEACHER_TUTORS("http://192.168.14.76:8080/sccgii/docente/tutores"),
	TEACHER_TUTORS_BY_CARRER("http://192.168.14.76:8080/sccgii/docente/tutors/");
	
	private String value;
	
	private WebServices(String value){
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}
}
