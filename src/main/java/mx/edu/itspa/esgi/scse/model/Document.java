package mx.edu.itspa.esgi.scse.model;

public interface Document {
	String getName();
	String getPath();
	
	default String header() {
		return "";
	}
	
	default String footer() {
		return "";
	}
	
	default String getSchoolPeriod() {
		return "SEPTIEMBRE 2022 - ENERO 2023";//SALE DE LA BASE DE DATOS
	}
}

/*
 * 
 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = format.parse("2022-09-05");
			Date endDate = format.parse("2023-01-13");
			Date dateToCheck = new Date();
			if (dateToCheck.after(startDate) && dateToCheck.before(endDate)) {
				return "ENERO - JUNIO";
			}
			if (!dateToCheck.before(startDate) && !dateToCheck.after(endDate)) {
				return "AGOSTO - DICIEMBRE";
			}
			return "JULIO-AGOSTO";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
 * */
