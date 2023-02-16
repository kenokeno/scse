package mx.edu.itspa.esgi.scse.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionPostgreSQL {
	private static final String HOST="localhost";
    private static final String PORT="5432";
    private static final String USER="postgres";
    private static final String PASSW="mysecretpassword";
    private static final String BD="essgi";
    
    public static Connection getConnection() {//throws SQLException
        Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://"+HOST+":"+PORT+";databaseName="+BD;
			conn = DriverManager.getConnection(connectionUrl,USER,PASSW);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
        return conn;
    }
}
