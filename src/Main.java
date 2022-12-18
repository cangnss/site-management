import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		String conUrl = "jdbc:sqlserver://localhost:50674; databaseName=Project; integratedSecurity=true;"; 

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conUrl);
			System.out.println("Connected...");
			System.out.println();
			
			// ...
			System.out.println("Do here some database operations...");
			Statement stmt = con.createStatement();
			/* Create Table 
			String sql = "CREATE TABLE CG " +
						"(id INTEGER NOT NULL, " +
						"firstname VARCHAR(50) NOT NULL, " +
						"lastname VARCHAR(50) NOT NULL, " +
						"age INTEGER NOT NULL, " +
						"PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			
			String insert = "INSERT INTO CG " + "VALUES (201,'Ali Can', 'Gunes',25)";
			stmt.executeUpdate(insert);
			System.out.println("executed");
			
			
			ResultSet rs;
			String select = "SELECT * FROM CG";
			rs = stmt.executeQuery(select);
			while (rs.next()) {
				String id = rs.getString("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String age = rs.getString("age");
				System.out.println("id: " + id + " firstname: " + firstname + " lastname: " + lastname + " age: " + age);
			}
			
			
			String sql = "CREATE TABLE Resident " +
					"(id INTEGER NOT NULL, " +
					"firstName VARCHAR(50) NOT NULL, " +
					"lastName VARCHAR(50) NOT NULL, " +
					"birthday DATE NOT NULL, " +
					"age AS (YEAR(CURRENT_TIMESTAMP)-YEAR(birthday)), " +
					"fullName AS (CONCAT(firstName, ' ', lastName)) PERSISTED, " +
					"apartmentId INTEGER NOT NULL, " +
					"PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			
			String deleteResident = "DELETE FROM Resident WHERE id = 1";
			stmt.execute(deleteResident);
			
			String insertResident = "INSERT INTO Resident " + "VALUES(1, 'Dilek', 'Yalcin','1999-04-02',1)";
			stmt.executeUpdate(insertResident);
			System.out.println("executed");
			*/
			String insertResident = "INSERT INTO Item " + "VALUES('Test', '225.50', '2')";
			stmt.executeUpdate(insertResident);
			System.out.println("executed");
			
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
