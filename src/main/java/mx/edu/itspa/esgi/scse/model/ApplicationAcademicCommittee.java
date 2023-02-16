package mx.edu.itspa.esgi.scse.model;

public class ApplicationAcademicCommittee extends FormatStudent<Student, Department>{
	
	private String request;
	
	private String academicReasons;
	
	private String personalMotives;
	
	private String others;
	
	public ApplicationAcademicCommittee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationAcademicCommittee(String request, String academicReasons, String personalMotives, String others) {
		super();
		this.request = request;
		this.academicReasons = academicReasons;
		this.personalMotives = personalMotives;
		this.others = others;
	}
	
	

	@Override
	public Student getSender() {
		// TODO Auto-generated method stub
		return new Student();//Sale de web service
	}

	@Override
	public Department getAddressee() {
		// TODO Auto-generated method stub
		return new Department();//Sale de web service
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getAcademicReasons() {
		return academicReasons;
	}

	public void setAcademicReasons(String academicReasons) {
		this.academicReasons = academicReasons;
	}

	public String getPersonalMotives() {
		return personalMotives;
	}

	public void setPersonalMotives(String personalMotives) {
		this.personalMotives = personalMotives;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Solicitud a Comite Académico";
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "Ruta...";
	}	
}
