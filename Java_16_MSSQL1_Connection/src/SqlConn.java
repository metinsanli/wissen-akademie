import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("all")
public class SqlConn {

	static final String DATABASE_URL = "jdbc:sqlserver://192.168.2.253:1433" + ";databasename=Northwind" + ";user=sa;password=Yon3tici";

	public static void main(String[] args) {

		Connection baglanti = null; // bir baglanti nesnesi tanimla
		Statement sorguIfadesi = null; // sorgunun yazilacagi ifade
		ResultSet veri = null; // sorgu sonucunda elde edilen veri
		// veri tabanina baglan
		try {
			baglanti = DriverManager.getConnection(DATABASE_URL); // baglanti
																	// kur
			sorguIfadesi = baglanti.createStatement(); // sorgu nesnesi yarat
			veri = sorguIfadesi.executeQuery("SELECT [EmployeeID],[LastName],[FirstName],[Title] FROM Employees");

			// sonuclari goruntule
			ResultSetMetaData metaData = veri.getMetaData();
			int sutunSayisi = metaData.getColumnCount(); // alinan tablonun kolon sayisini ver.
			System.out.printf("Northwind Database :");

			for (int i = 1; i <= sutunSayisi; i++)
				System.out.printf("%-8s\t", metaData.getCatalogName(i));
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