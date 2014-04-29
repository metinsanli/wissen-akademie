import java.util.Scanner;

public class Ogrenci {

	Scanner veri = new Scanner(System.in);
	public String ogrenciAdi;
	public int ogrenciNo;
	public double not1;
	public double not2;

	public double ortalama() {
		double ort;
		ort = (not1 + not2) / 2;
		return ort;
	} // end ortalama()

	public double ortalama(double n1, double n2) {
		double ort = (n1 + n2) / 2;
		return ort;
	} // end ortalama()

	public double ortalama(int notSayisi) {
		double ort = 0;

		for (int i = 1; i <= notSayisi; i++) {
			System.out.printf("\nLutfen %d. notunuzu giriniz = ", i);
			ort += veri.nextDouble();
		}

		return ort / notSayisi;
	} // end ortalama()

	public void notAl() {
		System.out.printf("\nnot1 girisi yapin > ");
		not1 = veri.nextDouble();
		System.out.printf("not2 girisi yapin > ");
		not2 = veri.nextDouble();
	} // end notAl()

	public void tanimla(String ogrenciAdi, int ogNo, int not1, int not2) {
		// this referans parametresi sinif degiskenini isaret eder.
		this.ogrenciAdi = ogrenciAdi;
		this.not1 = not1;
		this.not2 = not2;
		this.ogrenciNo = ogNo;
	} // end tanimla()

	public void bilgiler() {
		System.out.printf("\nOgrenci No : %d\nOgrenci Adi: %s", ogrenciNo, ogrenciAdi);
		System.out.printf("\n1.Not: %.1f 2.Not: %.1f Ortalama: %.1f\n", not1, not2, ortalama());
	} // end bilgiler()

} // end class