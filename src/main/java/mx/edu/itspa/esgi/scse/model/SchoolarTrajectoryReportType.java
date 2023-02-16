package mx.edu.itspa.esgi.scse.model;

public enum SchoolarTrajectoryReportType implements Document{
	PARTIAL_GRADES{
	      @Override
	      public String getName() {
	         return "Reporte de Desempeño Academico Semestral";
	      }
	      
	      @Override
	      public String getPath() {
	         return "Desempeño Academico Semestral.jasper";
	      }	      
	   }, 
	ACADEMIC_SEMAPHORE{
		   @Override
		      public String getName() {
		         return "Reporte de Focos Estudiantil";
		      }
		      
		      @Override
		      public String getPath() {
		    	  return "Focos Rojos.jasper";
		      }
	   },
	ACADEMIC_STATUS{
		   @Override
		      public String getName() {
		         return "Reporte de Estatus Academico";
		      }
		      
		      @Override
		      public String getPath() {
		    	  return "Estatus Academico.jasper";
		      }
	   };
}
