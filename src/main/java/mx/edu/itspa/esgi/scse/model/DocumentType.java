package mx.edu.itspa.esgi.scse.model;

public enum DocumentType {
	APPLICATION_ACADEMIC_COMMITTE(new ApplicationAcademicCommittee());

	protected Document document;

	DocumentType(Document document) {
		this.document = document;
	}
	
	public Document getValue() {
	     return this.getValue();
	 }
}
