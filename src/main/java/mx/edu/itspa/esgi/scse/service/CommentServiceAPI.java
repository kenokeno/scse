package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Comment;
import mx.edu.itspa.esgi.scse.repositories.CommentRepository;

public interface CommentServiceAPI extends GenericServiceAPI<Comment, Integer>, CommentRepository{

}
