package mx.edu.itspa.esgi.scse.model;

public enum Paths {
	HOME("Inicio","/home/"),
	TRAJECTORY_SCHOOL("Reportes de Trayectoria Escolar","/scse/streport/"), 
	REQUESTS("Solicitudes", "/scse/department/request/list"),
	COURSE_MANAGEMENT_REPORT("Reportes de Gestión del Curso","/scse/cmreport/");

	private final String name;
	private final String path;

	Paths(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
}
