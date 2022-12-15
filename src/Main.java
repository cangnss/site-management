import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		String conUrl = "jdbc:sqlserver://localhost:50674; databaseName=AdventureWorks2019; integratedSecurity=true;"; 

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conUrl);
			System.out.println("Connected...");
			System.out.println();
			// ...
			System.out.println("Do here some database operations...");
			
		} catch (Exception e) {
			System.out.println("Failed...");
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
					System.out.println();
					System.out.println("Disconnected...");
				} catch (Exception e) {
					System.out.println(e);
				}
		}

	}

}
