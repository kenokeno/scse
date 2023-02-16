package mx.edu.itspa.esgi.scse.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.DocumentCatalog;
import mx.edu.itspa.esgi.scse.repositories.DocumentCatalogDAO;

@Service
public class DocumentCatalogServiceImpl extends GenericServiceImpl<DocumentCatalog, Integer> implements DocumentCatalogServiceAPI{

	@Autowired
	private DocumentCatalogDAO documentDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<DocumentCatalog, Integer> getDAO() {
		// TODO Auto-generated method stub
		return documentDAO;
	}
}
