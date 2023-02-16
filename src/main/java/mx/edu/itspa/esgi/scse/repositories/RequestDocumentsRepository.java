package mx.edu.itspa.esgi.scse.repositories;

import java.util.List;

import mx.edu.itspa.esgi.scse.model.RequestDocuments;

public interface RequestDocumentsRepository {
	public abstract List<RequestDocuments> findByRequest(Integer id);
}
