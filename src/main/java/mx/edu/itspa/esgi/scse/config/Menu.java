package mx.edu.itspa.esgi.scse.config;

import java.util.HashMap;
import java.util.List;

import mx.edu.itspa.esgi.scse.model.Paths;
import mx.edu.itspa.esgi.scse.model.Roles;

final public class Menu {
	public final static HashMap<String,HashMap<String, String>> ACADEMIC;
	public final static HashMap<String,List<String>> PLANNING;
	public final static HashMap<String,List<String>> ADMINISTRATION;
	public final static HashMap<String,List<String>> BONDING;
	public final static HashMap<String,List<String>> QUALITY;
	//new HashMap<String, String>{"test":"test","test":"test"}
	static {
		ACADEMIC = new HashMap<String, HashMap<String, String>>();
		PLANNING = new HashMap<String, List<String>>();
		ADMINISTRATION = new HashMap<String, List<String>>();
		BONDING = new HashMap<String, List<String>>();
		QUALITY = new HashMap<String, List<String>>();
		ACADEMIC.put(
				Roles.ACADEMIC_SUBDIRECTOR.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.TRAJECTORY_SCHOOL.getName(),Paths.TRAJECTORY_SCHOOL.getPath());
						put(Paths.REQUESTS.getName(),Paths.REQUESTS.getPath());
						put(Paths.COURSE_MANAGEMENT_REPORT.getName(),Paths.COURSE_MANAGEMENT_REPORT.getPath());
					}
				});
		ACADEMIC.put(
				Roles.HEAD_ACADEMIC_DEVELOPMENT.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.TRAJECTORY_SCHOOL.getName(),Paths.TRAJECTORY_SCHOOL.getPath());
						put(Paths.REQUESTS.getName(),Paths.REQUESTS.getPath());
					}
				});
		ACADEMIC.put(
				Roles.HEAD_DIVISION.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.TRAJECTORY_SCHOOL.getName(),Paths.TRAJECTORY_SCHOOL.getPath());
						put(Paths.REQUESTS.getName(),Paths.REQUESTS.getPath());
						put(Paths.COURSE_MANAGEMENT_REPORT.getName(),Paths.COURSE_MANAGEMENT_REPORT.getPath());
					}
				});
		ACADEMIC.put(
				Roles.TUTORING_COORDINATOR.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.TRAJECTORY_SCHOOL.getName(),Paths.TRAJECTORY_SCHOOL.getPath());
						put(Paths.REQUESTS.getName(),Paths.REQUESTS.getPath());
					}
				});
		ACADEMIC.put(
				Roles.TEACHER.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.COURSE_MANAGEMENT_REPORT.getName(),Paths.COURSE_MANAGEMENT_REPORT.getPath());
					}
				});
		ACADEMIC.put(
				Roles.TUTOR.getValue(), new HashMap<String,String>(){
					private static final long serialVersionUID = 1L;
					{
						put(Paths.TRAJECTORY_SCHOOL.getName(),Paths.TRAJECTORY_SCHOOL.getPath());
					}
				});
	}
}
