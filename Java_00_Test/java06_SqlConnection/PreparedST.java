package java06_SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@SuppressWarnings("all")
public class PreparedST {

	private static Connection baglanti = null;
	private static PreparedStatement sorgu = null;
	private static ResultSet veri = null;

	public static void getAllData() {
		try {
			baglanti = DriverManager.getConnection("jdbc:sqlserver://10.0.0.10:1433;databasename=Northwind", "test", "D3n3m3123");
			sorgu = baglanti.prepareStatement("SELECT * FROM Employees");
			veri = sorgu.executeQuery();

			ResultSetMetaData metaData = veri.getMetaData();
			int sutunSayisi = metaData.getColumnCount();

			while (veri.next()) {
				for (int i = 1; i <= sutunSayisi; i++)
					System.out.print(veri.getObject(i) + "\t" + (i == sutunSayisi ? "\n" : ""));
			}
		} catch (SQLException e) {
			System.err.printf("\n%s", e.getMessage());
		} finally {
			try {
				veri.close();
				sorgu.close();
				baglanti.close();
			} catch (SQLException e) {
				System.err.printf("\n%s", e.getMessage());
			} catch (NullPointerException e) {
				System.err.printf("\n%s", e.getMessage());
			}
		}
	} // end method getAllData()

	public static void updateData() {
		try {
			baglanti = DriverManager.getConnection("jdbc:sqlserver://10.0.0.10:1433;databasename=Northwind", "test", "D3n3m3123");
			sorgu = baglanti.prepareStatement("INSERT INTO Employees (LastName, FirstName, Country, Title) VALUES (?,?,?,?)");
			sorgu.setString(1, "Metin");
			sorgu.setString(2, "Sanli");
			sorgu.setString(3, "Turkiye");
			sorgu.setString(4, "Baskan");
			sorgu.executeUpdate();
		} catch (SQLException e) {
			System.err.printf("\n%s", e.getMessage());
		}
	} // end method updateData()

	public static void main(String[] args) {
		PreparedST.updateData();
		PreparedST.getAllData();
	} // end method main()

} // END CLASS