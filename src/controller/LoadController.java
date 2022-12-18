package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadController {
	Connection con = null;
	String conUrl = "jdbc:sqlserver://localhost:50674; databaseName=Project; integratedSecurity=true;";

	public void LoadValues() {
		try {
			con = DriverManager.getConnection(conUrl);
			System.out.println("Connected...");
			System.out.println();
			// ...
			System.out.println("Do here some database operations...");
			Statement stmt = (Statement) con.createStatement();

			// Insert ApartmentName
			String insertApartment = "INSERT INTO Apartment " + "VALUES ('C'),('D'),('E'),('F')";
			stmt.executeUpdate(insertApartment);
			System.out.println("executed");
			ResultSet rs;
			String select = "SELECT * FROM Apartment";
			rs = stmt.executeQuery(select);
			while (rs.next()) {
				String apartmentName = rs.getString("apartmantName");
				System.out.println("apartmantName " + apartmentName);
			}
			rs.close();
			
			
			// Insert Resident
			String insertResident = "INSERT INTO Resident " + "VALUES ('Deniz', 'Aksoy','12-13-1990','M',3),"
					+ " ('Melike', 'Yılmaz','10-17-1996','F',3)," + " ('Esra', 'Durmaz','08-19-1985','F',3),"
					+ " ('Fatih', 'Köse','07-25-1987','M',3)," + " ('İlayda', 'Öztürk','11-08-1997','F',4),"
					+ " ('Sena', 'Aydın','10-21-1987','F',4)," + " ('Murat', 'Kaya','06-04-1990','M',4),"
					+ " ('Çiğdem', 'İnci','03-02-1975','F',4)," + " ('Mete', 'Akın','04-13-1972','M',5),"
					+ " ('Semih', 'Güler','04-25-1982','M',5)," + " ('Sinan', 'Bulut','01-23-1992','M',5),"
					+ " ('Aslı', 'Şahin','05-20-1973','F',5)," + " ('İlker', 'Erdem','10-23-1983','M',6),"
					+ " ('Aysel', 'Çiçek','07-28-1987','F',6)," + " ('Arda', 'Esen','02-16-1994','M',6),"
					+ " ('Ayşe', 'İnan','03-24-1981','F',6)";
			stmt.executeUpdate(insertResident);
			System.out.println("executed");

			ResultSet rs2;
			String selectResident = "SELECT * FROM Resident";
			rs2 = stmt.executeQuery(selectResident);
			while (rs2.next()) {
				String firstname = rs2.getString("firstName");
				String lastname = rs2.getString("lastName");
				String birthday = rs2.getString("birthday");
				String gender = rs2.getString("gender");
				int apartmentId = rs2.getInt("apartmentId");
				System.out.println(" firstname: " + firstname + " lastname: " + lastname + " Birtyday: " + birthday
						+ "gender" + gender + "apartmentId" + apartmentId);
			}
			rs2.close();
			
			// Insert Roles
			String insertRoles = "INSERT INTO Roles " + "VALUES ('Manager','10','3')," + " ('Asst. Manager','11','3'),"
					+ " ('Controller','12','3')," + " ('Manager', '14','4')," + " ('Asst. Manager','15','4'),"
					+ " ('Controller','16','4')," + " ('Manager','18','5')," + " ('Asst. Manager','19','5'),"
					+ " ('Controller','20','5')," + " ('Manager','22','6')," + " ('Asst. Manager','23','6'),"
					+ " ('Controller','24','6')";
			stmt.executeUpdate(insertRoles);
			System.out.println("executed");
			
			ResultSet rs3;
			String selectRoles = "SELECT * FROM Roles";
			rs3 = stmt.executeQuery(selectRoles);
			while (rs3.next()) {
				String role = rs3.getString("role");
				int residentId = rs3.getInt("residentId");
				int apartmentId = rs3.getInt("apartmentId");
				System.out.println(" role: " + role + " residentId: " + residentId + " apartmentıd: " + apartmentId);
			}
			rs3.close();
			
			// Insert Item
			String insertItem = "INSERT INTO Item " + "VALUES('Electricity Bill','350','3'),"
					+ "('Electricity Bill','450','4')," + "('Electricity Bill','475','5'),"
					+ "('Electricity Bill','418','6')," + "('Water Bill','500','3')," + "('Water Bill','380','4'),"
					+ "('Water Bill','556','5')," + "('Water Bill','362','6')," + "('Cleaning Material','250','3'),"
					+ "('Cleaning Material','330','4')," + "('Cleaning Material','315','5'),"
					+ "('Cleaning Material','324','6')";
			stmt.executeUpdate(insertItem);
			System.out.println("executed");

			ResultSet rs4;
			String selectItem = "SELECT * FROM Item";
			rs4 = stmt.executeQuery(selectItem);
			while (rs4.next()) {
				String itemName = rs4.getString("itemName");
				float price = rs4.getFloat("price");
				int apartmentId = rs4.getInt("apartmentId");
				System.out.println(" itemName: " + itemName + " price: " + price + " apartmentıd: " + apartmentId);
			}
			rs4.close();
			
			// Insert Account
			String insertAccount = "INSERT INTO Account " + "VALUES ('C Apt','3','10','600'),"
					+ "('C Apt','3','11','600')," + "('C Apt','3','12','600')," + "('C Apt','3','13','600'),"
					+ "('D Apt','4','14','650')," + "('D Apt','4','15','650')," + "('D Apt','4','16','650'),"
					+ "('D Apt','4','17','650')," + "('E Apt','5','18','700')," + "('E Apt','5','19','700'),"
					+ "('E Apt','5','20','700')," + "('E Apt','5','21','700')," + "('F Apt','6','22','550'),"
					+ "('F Apt','6','23','550')," + "('F Apt','6','24','550')," + "('F Apt','6','25','550')";
			stmt.executeUpdate(insertAccount);
			System.out.println("executed");
			
			ResultSet rs5;
			String selectAccounts = "SELECT * FROM Account";
			rs5 = stmt.executeQuery(selectAccounts);
			while (rs5.next()) {
				String accountName = rs5.getString("accountName");
				int apartmentId = rs5.getInt("apartmentId");
				int residentId = rs5.getInt("residentId");
				int monthlyPayment = rs5.getInt("monthlyPayment");

				System.out.println(" accountName: " + accountName + " apartmentıd: " + apartmentId + " residentId: "
						+ residentId + "monthlyPayment" + monthlyPayment);
			}
			rs5.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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