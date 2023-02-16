package mx.edu.itspa.esgi.scse.commons;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

public class ReporteToPdf {
	
	public static boolean generarPdf(String reports_path, Map<String, Object> parameters, HttpServletResponse response, ServletContext cntx) {

		Connection conexion = null;
		byte[] bytes = null;
		System.out.println(cntx.getRealPath(reports_path));
		File reportFile = new File(cntx.getRealPath(reports_path));
		String report = reportFile.getPath();
		System.out.println("Report File Path: " + report);
		try {
			conexion = ConectionSQLServer.getConnection();
			bytes = JasperRunManager.runReportToPdf(report, parameters, conexion);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error generando Jasper");
			//mensajeError("Error al conectarse con la Base de Datos. Intentelo mas tarde");
			return false;
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error cerrando conexion");
				//mensajeError("Error al conectarse con la Base de Datos. Intentelo mas tarde");
			}
		}
		return true;
	}
	/*
	private static void mensajeError(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		facesContext.addMessage("Trayectoria Escolar", facesMessage);
	}*/
}
