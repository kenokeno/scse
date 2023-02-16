package mx.edu.itspa.esgi.scse.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.edu.itspa.esgi.scse.model.Request;

public interface RequestDAO extends CrudRepository <Request, Integer>{
	
}
