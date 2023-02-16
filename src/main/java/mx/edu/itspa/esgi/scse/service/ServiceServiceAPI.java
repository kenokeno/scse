package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Service;
import mx.edu.itspa.esgi.scse.repositories.ServiceRepository;

public interface ServiceServiceAPI extends GenericServiceAPI<Service, Integer>, ServiceRepository{
	
	
}