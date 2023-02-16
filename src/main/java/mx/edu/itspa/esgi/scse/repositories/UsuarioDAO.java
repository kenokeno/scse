package mx.edu.itspa.esgi.scse.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.edu.itspa.esgi.scse.model.User;

public interface UsuarioDAO extends CrudRepository <User, Integer>{
	User findByUsername(String username);
}
