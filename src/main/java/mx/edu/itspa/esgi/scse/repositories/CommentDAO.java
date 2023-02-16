package mx.edu.itspa.esgi.scse.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.edu.itspa.esgi.scse.model.Comment;

public interface CommentDAO extends CrudRepository <Comment, Integer>{

}
