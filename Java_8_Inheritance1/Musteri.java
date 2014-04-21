public class Musteri {

	public String musteriAdi;
	public String musteriSoyadi;
	public String unvan;
	public char musteriTur; // B:bireysel K:kurumsal
	public String hesapNo;
	private double bakiye;
	public String tel;

	public void setBakiye(double bakiye) {
		if (bakiye >= 0)
			this.bakiye = bakiye;
		else
			System.out.println("Lutfen pozitif deger girin : ");
	} // end method setBakiye()

	public double getBakiye() {
		return bakiye;
	} // end method getBakiye()

	public void paraYatir(double tutar) {
		if (bakiye >= 0)
			this.bakiye += tutar;
		else
			System.out.println("Lutfen pozitif deger girin : ");
	} // end method paraYatir()

} // end class
