package mx.edu.itspa.esgi.scse.model;

public enum CourseManagementReportType implements Document{
	PARTIAL_REPORT{
	      @Override
	      public String getName() {
	         return "Reporte de Calificaciones Parciales";
	      }
	      
	      @Override
	      public String getPath() {
	         return "Reporte de Calificaciones Parciales.jasper";
	      }	      
	   }, 
	FINAL_REPORT{
		   @Override
		      public String getName() {
		         return "Reporte de Calificaciones Finales";
		      }
		      
		      @Override
		      public String getPath() {
		    	  return "Reporte de Calificaciones Final.jasper";
		      }
	   }
}
