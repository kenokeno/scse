package mx.edu.itspa.esgi.scse.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.EncryptHash;
import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.User;
import mx.edu.itspa.esgi.scse.repositories.UsuarioDAO;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl extends GenericServiceImpl<User, Integer> implements UsuarioServiceAPI, UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<User, Integer> getDAO() {
		// TODO Auto-generated method stub
		return usuarioDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUsernameAndPassword(String clave, String password) {
		// TODO Auto-generated method stub
		User user = null;
		String passwordHash=EncryptHash.getHash(password.getBytes(),"SHA-1");
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.User(d.id, d.clave, d.password, d.rfid, d.department) FROM User d inner join d.department WHERE d.clave='"+clave+"' AND d.password='"+passwordHash+"'", User.class);
		List<User> results = query.getResultList();
		if (!results.isEmpty())
			user = (User) results.get(0);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usuarioDAO.findByUsername(username);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		user.getRoles().stream().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getName())));
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}	
}