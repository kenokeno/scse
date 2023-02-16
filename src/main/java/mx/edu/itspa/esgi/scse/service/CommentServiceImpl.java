package mx.edu.itspa.esgi.scse.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceImpl;
import mx.edu.itspa.esgi.scse.model.Comment;
import mx.edu.itspa.esgi.scse.repositories.CommentDAO;

@Service
public class CommentServiceImpl extends GenericServiceImpl<Comment, Integer> implements CommentServiceAPI{

	@Autowired
	private CommentDAO commentDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CrudRepository<Comment, Integer> getDAO() {
		// TODO Auto-generated method stub
		return commentDAO;
	}
	/**
	 * @param id
	 * @param user
	 * @param request
	 * @param comment
	 * @param updated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findByRequest(Integer id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT NEW mx.edu.itspa.esgi.scse.model.Comment(d.id, d.user, d.request, d.comment, d.updated) FROM Comment d inner join d.request WHERE d.request.id=:commentId",Comment.class).setParameter("commentId", id);
		List<Comment> results = query.getResultList();
		return results;
	}
}
