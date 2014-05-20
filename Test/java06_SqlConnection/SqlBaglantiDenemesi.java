package java06_SqlConnection;

import java.sql.*;

@SuppressWarnings("all")
public class SqlBaglantiDenemesi {

	public static String veriTabani = "dbPastane";
	public static String kullaniciAdi = "test";
	public static String sifre = "D3n3m3123";
	public static String adres = "jdbc:sqlserver://10.0.0.10:1433";

	public SqlBaglantiDenemesi(String hedefAdres, String vtAdi, String userName, String password, String sorguKomutu) throws Exception {

		Connection baglanti = DriverManager.getConnection(hedefAdres + ";databasename=" + vtAdi + ";user=" + userName + ";password=" + password);
		Statement sorguIfadesi = baglanti.createStatement();
		ResultSet veri = sorguIfadesi.executeQuery(sorguKomutu);

		ResultSetMetaData metaData = veri.getMetaData();
		int sutunSayisi = metaData.getColumnCount(); // alinan tablonun kolon sayisini ver.

		while (veri.next()) {
			for (int i = 1; i <= sutunSayisi; i++)
				System.out.printf("%-20s", veri.getObject(i));
			System.out.println();
		}
		baglanti.close();
	} // end constructor

	public static void main(String[] args) throws Exception {
		new SqlBaglantiDenemesi(adres, veriTabani, kullaniciAdi, sifre, "SELECT * FROM dbo.View_Maliyet --WHERE Adi Like 'Browni'");
	} // end main()

} // END CLASS