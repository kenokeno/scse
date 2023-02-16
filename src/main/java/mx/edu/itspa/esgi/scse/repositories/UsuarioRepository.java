package mx.edu.itspa.esgi.scse.repositories;

import mx.edu.itspa.esgi.scse.model.User;

public interface UsuarioRepository{
	public abstract User findByUsernameAndPassword(String username, String password);
}
