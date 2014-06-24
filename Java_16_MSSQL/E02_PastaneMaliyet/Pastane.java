package E02_PastaneMaliyet;
@SuppressWarnings("all")
public class Pastane {

	public static String veriTabani = "dbPastane";
	public static String kullaniciAdi = "test";
	public static String sifre = "D3n3m3123";
	public static String adres = "jdbc:sqlserver://10.0.0.10:1433";

	public static void main(String[] args) {
		VeriTabani vt = new VeriTabani();
		vt.getBilgi(adres, veriTabani, kullaniciAdi, sifre, "SELECT * FROM dbo.View_Maliyet --WHERE Adi Like 'Browni'");
		// vt.getBilgi("Northwind", kullaniciAdi, sifre, "SELECT * FROM Products");
	}

}