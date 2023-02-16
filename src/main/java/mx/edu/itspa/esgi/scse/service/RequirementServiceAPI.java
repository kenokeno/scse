package mx.edu.itspa.esgi.scse.service;

import mx.edu.itspa.esgi.scse.commons.GenericServiceAPI;
import mx.edu.itspa.esgi.scse.model.Requirement;
import mx.edu.itspa.esgi.scse.repositories.RequirementRepository;

public interface RequirementServiceAPI extends GenericServiceAPI<Requirement, Integer>, RequirementRepository{

}
