package mx.edu.itspa.esgi.scse.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.RequestDocuments;
import mx.edu.itspa.esgi.scse.repositories.RequestDocumentsDAO;

@Service
public class RequestDocumentsServiceImpl extends GenericServiceImpl<RequestDocuments, Integer> implements RequestDocumentsServiceAPI{

	@Autowired
	private RequestDocumentsDAO commentDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<RequestDocuments, Integer> getDAO() {
		// TODO Auto-generated method stub
		return commentDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestDocuments> findByRequest(Integer id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.RequestDocuments(d.request, d.document, d.path) FROM RequestDocuments d inner join d.request WHERE d.request.id='"+id+"'", RequestDocuments.class);
		List<RequestDocuments> results = query.getResultList();
		return results;
	}
}
