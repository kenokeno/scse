package mx.edu.itspa.esgi.scse.repositories;

import mx.edu.itspa.esgi.scse.model.Department;

public interface DepartmentRepository {
	public abstract Department findByUser(Integer userId);
}
