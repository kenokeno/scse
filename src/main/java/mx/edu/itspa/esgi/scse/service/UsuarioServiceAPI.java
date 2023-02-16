package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.User;
import mx.edu.itspa.esgi.scse.repositories.UsuarioRepository;


public interface UsuarioServiceAPI extends GenericServiceAPI<User, Integer>, UsuarioRepository{
	
	
}
