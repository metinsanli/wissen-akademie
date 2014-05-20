import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("all")
public class VeriTabani {

	// static final String DATABASE_URL = "jdbc:sqlserver://192.168.2.253:1433" + ";databasename=dbPastane" + ";user=test;password=D3n3m3123";

	public static void getBilgi(String hedefAdres, String vtAdi, String userName, String password, String sorguKomutu) {

		Connection baglanti = null; // bir baglanti nesnesi tanimla
		Statement sorguIfadesi = null; // sorgunun yazilacagi ifade
		ResultSet veri = null; // sorgu sonucunda elde edilen veri
		// veri tabanina baglan
		try {
			baglanti = DriverManager.getConnection(hedefAdres + ";databasename=" + vtAdi + ";user=" + userName + ";password=" + password);
			// baglanti kur sorgu nesnesi yarat
			sorguIfadesi = baglanti.createStatement();
			veri = sorguIfadesi.executeQuery(sorguKomutu);

			// sonuclari goruntule
			ResultSetMetaData metaData = veri.getMetaData();
			int sutunSayisi = metaData.getColumnCount(); // alinan tablonun kolon sayisini ver.
			System.out.printf("\n%s Database Bilgileri:\n\n", vtAdi);

			for (int i = 1; i <= sutunSayisi; i++)
				System.out.printf("%-20s", metaData.getColumnLabel(i));
			System.out.println();

			while (veri.next()) {
				for (int i = 1; i <= sutunSayisi; i++)
					System.out.printf("%-20s", veri.getObject(i));
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