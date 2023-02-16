package mx.edu.itspa.esgi.scse.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class RequestDocumentsId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "request_id")
    private Integer requestId;	
    
    @Column(name = "document_id")
    private Integer documentId;

	public RequestDocumentsId() {
	}

	public RequestDocumentsId(Integer requestId, Integer documentId) {
		super();
		this.requestId = requestId;
		this.documentId = documentId;
	}
	
	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getServiceId() {
		return documentId;
	}

	public void setServiceId(Integer documentId) {
		this.documentId = documentId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) 
            return false;

        RequestDocumentsId that = (RequestDocumentsId) o;
        return Objects.equals(requestId, that.requestId) && 
               Objects.equals(documentId, that.documentId);
    }

    @Override   
    public int hashCode() {
        return Objects.hash(requestId, documentId);
    }

    @Override
    public String toString() {
        return "RequestDocumentsId [requestId=" + requestId + ", documentId=" + documentId + "]";
    }
    
}
