package mx.edu.itspa.esgi.scse.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.Request;
import mx.edu.itspa.esgi.scse.repositories.RequestDAO;

@Service
public class RequestServiceImpl extends GenericServiceImpl<Request, Integer> implements RequestServiceAPI{

	@Autowired
	private RequestDAO requestDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<Request, Integer> getDAO() {
		// TODO Auto-generated method stub
		return requestDAO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> findByDepartment(Integer departmentId) {
		// TODO Auto-generated method stub		
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.Request(d.id, d.user, d.service, d.status, d.created, d.updated) FROM Request d inner join d.status inner join d.status.service.department WHERE d.status.service.department.id=:departmentId", Request.class).setParameter("departmentId", departmentId);
		List<Request> requests = query.getResultList();
		return requests;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> findByUser(String clave) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.Request(d.id, d.user, d.service, d.status, d.created, d.updated) FROM Request d WHERE d.user.clave='"+clave+"'", Request.class);
		List<Request> requests = query.getResultList();
		return requests;
	}
}
