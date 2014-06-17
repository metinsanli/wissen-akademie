package E01_PersonelExample;

/**
 * SOYUT SINIF NEDEN GEREKLIDIR?<br>
 * <br>
 * Bazi durumlarda, yapilacak islere yada verilecek bilgilere uyan somut bir ust
 * sinif ile ona ait somut degiskenler ve somut metodlar tanimlamak mumkun
 * olmayabilir. Ornegin Kuslar, Baliklar, Aslanlar, Atlar gibi farkli Hayvan alt
 * siniflarini dusunelim. Bu siniflarin ortak ozellikleri ve davranislari
 * vardir. Tum bu nesneleri Hayvanlar isimli tek bir ust sinifta toplayabiliriz.
 * Mesela her siniftaki hayvanlar beslenirler ama beslenme yontemleri farklidir.
 * Yani Hayvanlar ust sinifinda beslenme yontemlerini her hayvan icin tek bir
 * yemekYe() isimli metodla kesin olarak ifade edemeyiz. O nedenle Hayvanlar ust
 * sinifina yemekYe() isimli metodu tanimlayip govdesini bos birakiriz. Boylece
 * Hayvanlar sinifi abstract(soyut) bir sinif olur. Bundan sonra onu extend eden
 * alt siniflar (mesela: Balik sinifi) kendi turlerine gore yemekYe() metodunu
 * kurgulayabilirler. Bu sayede farkli Hayvanlarin yemek yemelerinin nasil
 * belirlenecegi konusunda bir standart belirlemis oluruz.
 */

abstract class Personel {

	protected int sicilNo;
	protected String soyAd;
	protected String ad;

	public abstract void sicilNoVer(int sicil);

	public abstract void soyAdVer(String soyad);

	public abstract void adVer(String ad);

	public abstract double ucretHesapla();

	public String guncelle() {
		return "Isci Sicil No :" + sicilNo + " Adi : " + ad + " Soyadi: " + soyAd + " - GUNCELLENDI.";
	} // end method guncelle()

	public String ekle() {
		return "Isci Sicil No :" + sicilNo + " Adi : " + ad + " Soyadi: " + soyAd + " - EKLENDI.";
	} // end method ekle()

	public String sil() {
		return "Isci Sicil No :" + sicilNo + " Adi : " + ad + " Soyadi: " + soyAd + " - SILINDI.";
	} // end method sil()

	public String ara() {
		return "Isci Sicil No :" + sicilNo + " Adi : " + ad + " Soyadi: " + soyAd + " - BULUNDU.";
	} // end method ara()

} // end class
