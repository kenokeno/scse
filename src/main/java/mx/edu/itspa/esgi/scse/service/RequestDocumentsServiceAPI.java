package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.RequestDocuments;
import mx.edu.itspa.esgi.scse.repositories.RequestDocumentsRepository;

public interface RequestDocumentsServiceAPI extends GenericServiceAPI<RequestDocuments, Integer>, RequestDocumentsRepository{

}
