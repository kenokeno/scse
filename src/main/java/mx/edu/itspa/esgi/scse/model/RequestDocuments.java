package mx.edu.itspa.esgi.scse.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "request_documents")
@IdClass(RequestDocumentsId.class)
public class RequestDocuments implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer requestId;
	
	@Id
	private Integer documentId;
	
	@Column(name = "path")
    private String path;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "request_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Request request;
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_id", referencedColumnName = "id", insertable = false, updatable = false)
    private DocumentCatalog documentCatalog;

	public RequestDocuments() {}

	public RequestDocuments(Request request, DocumentCatalog documentCatalog, String path) {
		this.requestId = request.getId();
		this.documentId = documentCatalog.getId();
		this.request = request;
		this.documentCatalog = documentCatalog;
		this.path = path;
	}	
    
	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public DocumentCatalog getDocument() {
		return documentCatalog;
	}

	public void setDocument(DocumentCatalog documentCatalog) {
		this.documentCatalog = documentCatalog;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        RequestDocuments that = (RequestDocuments) o;
        return Objects.equals(request, that.request) &&
               Objects.equals(documentCatalog, that.documentCatalog);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(request, documentCatalog);
    }
    
    @Override
    public String toString() {
        return "RequestDocumentsRepository [requestId=" + requestId + ", documentId=" + documentId + ", path=" + path
                + ", request=" + request + ", documentCatalog=" + documentCatalog + "]";
    }
}
