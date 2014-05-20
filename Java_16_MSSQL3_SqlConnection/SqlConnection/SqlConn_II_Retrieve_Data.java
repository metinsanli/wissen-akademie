package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConn_II_Retrieve_Data {

	public static String tableName = "Products";

	public static void viewTable() throws Exception {
		Statement stmt = null;
		String query = "SELECT [ProductID], [UnitsInStock], [UnitPrice], [ReorderLevel] FROM " + tableName;
		try {
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Product Code\tUnits In Order\tList Price\tReorder Level\tColumn Number");
			while (rs.next()) {
				String productCode = rs.getString("ProductID");
				double unitsInOrder = rs.getDouble("UnitsInStock");
				float listPrice = rs.getFloat("UnitPrice");
				int reorderLevel = rs.getInt("ReorderLevel");
				System.out.println(productCode + "\t\t" + unitsInOrder + "\t\t" + listPrice + "\t\t" + reorderLevel + "\t\t" + rs.getRow());
			} // end while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	} // end method viewTable()

	private static Connection getConnection() throws Exception {
		final String DATABASE_URL = "jdbc:sqlserver://10.0.0.10:1433" + ";databasename=Northwind" + ";user=test;password=D3n3m3123";
		return DriverManager.getConnection(DATABASE_URL);
	} // end method getConnection()

	public static void main(String[] args) throws Exception {
		viewTable();
	} // end method main()

} // END CLASS