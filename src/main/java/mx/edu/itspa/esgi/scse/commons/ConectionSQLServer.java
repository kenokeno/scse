package mx.edu.itspa.esgi.scse.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionSQLServer {
	private static final String HOST="192.168.14.76";
    private static final String PORT="55061";
    private static final String USER="sccgii";
    private static final String PASSW="sccgii.2021";
    private static final String BD="INVENTARIOSTEC";
    
    public static Connection getConnection() {//throws SQLException
        Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://"+HOST+":"+PORT+";databaseName="+BD;
			conn = DriverManager.getConnection(connectionUrl,USER,PASSW);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al conectar la bd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
        return conn;
    }
}
