package mx.edu.itspa.esgi.scse.model;

import java.util.HashMap;
import java.util.Map;

public enum Degrees {

	GESTION_EMPRESARIAL(1, "INGENIERÍA EN GESTIÓN EMPRESARIAL", Departments.DIVISION_GESTION_EMPRESARIAL.getValue()), 
	ADMINISTRACION(5, "INGENIERÍA EN ADMINISTRACIÓN",Departments.DIVISION_ADMINISTRACION.getValue()),
	DESARROLLO_COMUNITARIO(6, "INGENIERÍA EN DESARROLLO COMUNITARIO",Departments.DIVISION_DESARROLLO_COMUNITARIO.getValue()), 
	AMBIENTAL(7, "INGENIERÍA AMBIENTAL",Departments.DIVISION_AMBIENTAL.getValue()),
	TICS(8, "INGENIERÍA EN TICS",Departments.DIVISION_TICS.getValue()), 
	BIOMEDICA(9,"INGENIERÍA BIOMÉDICA", Departments.DIVISION_BIOMEDICA.getValue());

	private static final Map<String, Degrees> BY_NAME = new HashMap<>();
    private static final Map<Integer, Degrees> BY_ID = new HashMap<>();
    private static final Map<String, Degrees> BY_DEPARTMENT = new HashMap<>();
    
    static {
        for (Degrees e : values()) {
        	BY_NAME.put(e.name, e);
        	BY_ID.put(e.id, e);
        	BY_DEPARTMENT.put(e.department, e);
        }
    }
    
	private final String name;
	private final Integer id;
	private final String department;

	Degrees(Integer id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static Degrees valueOfName(String name) {
		return BY_NAME.get(name);
	}
	
	public static Degrees valueOfID(Integer id) {
		return BY_ID.get(id);
	}
	
	public static Degrees valueOfDepartment(String department) {
		return BY_DEPARTMENT.get(department);
	}
}
