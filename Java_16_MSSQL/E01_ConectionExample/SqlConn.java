package E01_ConectionExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("all")
public class SqlConn {

	static final String DATABASE_URL = "jdbc:sqlserver://10.0.0.10:1433" + ";databasename=Northwind" + ";user=test;password=D3n3m3123";

	public static void main(String[] args) {

		Connection baglanti = null; // bir baglanti nesnesi tanimla
		Statement sorguIfadesi = null; // sorgunun yazilacagi ifade
		ResultSet veri = null; // sorgu sonucunda elde edilen veri
		// veri tabanina baglan
		try {
			baglanti = DriverManager.getConnection(DATABASE_URL); // baglanti kur sorgu nesnesi yarat
			sorguIfadesi = baglanti.createStatement();
			veri = sorguIfadesi.executeQuery("SELECT LastName,FirstName,Title FROM Employees WHERE EmployeeID IN( '1','2','5','8')");

			// sonuclari goruntule
			ResultSetMetaData metaData = veri.getMetaData();
			int sutunSayisi = metaData.getColumnCount(); // alinan tablonun kolon sayisini ver.
			System.out.printf("Northwind Database :\n\n");

			for (int i = 1; i <= sutunSayisi; i++)
				System.out.printf("%-8s\t", metaData.getColumnLabel(i));
			System.out.println();

			while (veri.next()) {
				for (int i = 1; i <= sutunSayisi; i++)
					System.out.printf("%-8s\t", veri.getObject(i));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				veri.close();
				sorguIfadesi.close();
				baglanti.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end method main()
} // END CLASS