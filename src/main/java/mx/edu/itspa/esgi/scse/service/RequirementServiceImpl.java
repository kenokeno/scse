package mx.edu.itspa.esgi.scse.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.Requirement;
import mx.edu.itspa.esgi.scse.repositories.RequirementDAO;

@Service
public class RequirementServiceImpl extends GenericServiceImpl<Requirement, Integer> implements RequirementServiceAPI{

	@Autowired
	private RequirementDAO requirementDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<Requirement, Integer> getDAO() {
		// TODO Auto-generated method stub
		return requirementDAO;
	}
}
