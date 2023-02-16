package mx.edu.itspa.esgi.scse.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.repositories.ServiceDAO;

@Service
public class ServiceServiceImpl extends GenericServiceImpl<mx.edu.itspa.esgi.scse.model.Service, Integer> implements ServiceServiceAPI{

	@Autowired
	private ServiceDAO serviceDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<mx.edu.itspa.esgi.scse.model.Service, Integer> getDAO() {
		// TODO Auto-generated method stub
		return serviceDAO;
	}	
}
