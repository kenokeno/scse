package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Department;
import mx.edu.itspa.esgi.scse.repositories.DepartmentRepository;

public interface DepartmentServiceAPI extends GenericServiceAPI<Department, Integer>, DepartmentRepository{

}
