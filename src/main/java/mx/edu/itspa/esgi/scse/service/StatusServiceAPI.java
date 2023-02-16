package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Status;
import mx.edu.itspa.esgi.scse.repositories.StatusRepository;

public interface StatusServiceAPI extends GenericServiceAPI<Status, Integer>, StatusRepository{

}
