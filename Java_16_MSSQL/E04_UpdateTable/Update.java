package E04_UpdateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SuppressWarnings("all")
public class Update {

	String tableName = "Products";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	private ResultSet getRS() throws Exception {
		String query = "SELECT [ProductID], [UnitsInStock], [UnitPrice], [ReorderLevel] FROM " + tableName;
		final String DATABASE_URL = "jdbc:sqlserver://10.0.0.10:1433" + ";databasename=Northwind" + ";user=test;password=D3n3m3123";
		conn = DriverManager.getConnection(DATABASE_URL);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(query);
		return rs;
	} // end method getRS()

	public void modifyPrices(float percentage) throws Exception {
		try {
			getRS();
			while (rs.next()) {
				float f = rs.getFloat("UnitPrice");
				rs.updateFloat("UnitPrice", f * percentage);
				rs.updateRow();
			} // end while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	} // end method modifyPrices()

} // END CLASS