package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Request;
import mx.edu.itspa.esgi.scse.repositories.RequestRepository;

public interface RequestServiceAPI extends GenericServiceAPI<Request, Integer>, RequestRepository{

}
