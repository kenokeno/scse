package mx.edu.itspa.esgi.scse.repositories;

import java.util.List;

import mx.edu.itspa.esgi.scse.model.Comment;

public interface CommentRepository {
	public abstract List<Comment> findByRequest(Integer id);
}
