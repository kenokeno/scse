package mx.edu.itspa.esgi.scse.model;

import mx.edu.itspa.esgi.scse.commons.Mapping;

// DEBE COINCIDIR CON CLASS Mapping IN COMMONS
public enum Roles {
	ACADEMIC_SUBDIRECTOR("SUBDIRECTOR ACADÉMICO"), 
	HEAD_DIVISION("JEFE DE DIVISIÓN"),
	HEAD_ACADEMIC_DEVELOPMENT("JEFE DE DESARROLLO ACADÉMICO"), 
	TUTORING_COORDINATOR("REPRESENTANTE COORDINACION DE TUTORIAS"),
	TEACHER(Mapping.TEACHER),
	TUTOR("TUTOR"),
	STUDENT(Mapping.STUDENT);

	private final String value;

	Roles(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
