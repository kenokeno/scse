package mx.edu.itspa.esgi.scse.repositories;

import java.util.List;

import mx.edu.itspa.esgi.scse.model.Request;

public interface RequestRepository {
	public abstract List<Request> findByDepartment(Integer departmentId);
	public abstract List<Request> findByUser(String clave);
}
