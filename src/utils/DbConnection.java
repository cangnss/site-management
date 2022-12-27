package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
	public static Connection createConnection() {
		Connection con = null;
		String conUrl = "jdbc:sqlserver://localhost:50674; databaseName=Project; integratedSecurity=true;";
		try {			
			con = DriverManager.getConnection(conUrl);
			System.out.println("baglandi");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("hata");
		}
		return con;
	}
}
