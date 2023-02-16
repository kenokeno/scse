package mx.edu.itspa.esgi.scse.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.Department;
import mx.edu.itspa.esgi.scse.repositories.DepartmentDAO;

@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, Integer> implements DepartmentServiceAPI{

	@Autowired
	private DepartmentDAO deparmentDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<Department, Integer> getDAO() {
		// TODO Auto-generated method stub
		return deparmentDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Department findByUser(Integer userId) {
		// TODO Auto-generated method stub
		Department department = null;
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.Department(d.id, d.name) FROM User u inner join u.department d WHERE u.id=:userId", Department.class).setParameter("userId", userId);
		List<Department> results = query.getResultList();
		if (!results.isEmpty())
			department = results.get(0);
		return department;
	}

}
