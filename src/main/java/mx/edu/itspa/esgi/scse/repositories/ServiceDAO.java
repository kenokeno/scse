package mx.edu.itspa.esgi.scse.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.edu.itspa.esgi.scse.model.Service;

public interface ServiceDAO extends CrudRepository <Service, Integer>{
	
}
