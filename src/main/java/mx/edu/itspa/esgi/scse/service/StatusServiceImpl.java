package mx.edu.itspa.esgi.scse.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.Status;
import mx.edu.itspa.esgi.scse.repositories.StatusDAO;

@Service
public class StatusServiceImpl extends GenericServiceImpl<Status, Integer> implements StatusServiceAPI{

	@Autowired
	private StatusDAO statusDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<Status, Integer> getDAO() {
		// TODO Auto-generated method stub
		return statusDAO;
	}
}
