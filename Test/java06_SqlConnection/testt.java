package java06_SqlConnection;

import java.sql.*;

@SuppressWarnings("all")
public class testt {

	public static void main(String[] args) throws Exception {
		Connection baglanti = DriverManager.getConnection("jdbc:sqlserver://10.0.0.10:1433;databasename=Northwind;user=test;password=D3n3m3123");
		Statement ifade = baglanti.createStatement();
		ResultSet tablo = ifade.executeQuery("SELECT TOP 10 * FROM Products");

		ResultSetMetaData meta = tablo.getMetaData();
		int sutunAdet = meta.getColumnCount();
		String sutunAdi;
		for (int i = 1; i <= sutunAdet; i++) {
			System.out.printf("%-20s", meta.getColumnName(i) + (i == sutunAdet ? "\n" : ""));
		}

		while (tablo.next()) {
			for (int i = 1; i <= sutunAdet; i++) {
				System.out.printf("%-20s", tablo.getObject(i) + (i == sutunAdet ? "\n" : ""));
			}
		}
	}
}