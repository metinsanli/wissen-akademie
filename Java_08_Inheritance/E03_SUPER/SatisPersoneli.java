package E03_SUPER;

public class SatisPersoneli extends Personel {
	public double satisTutari;
	public double primYuzdesi;

	public SatisPersoneli() {
		super(); // extend edilen sinifin constructor'ina erismek icin
	}

	public SatisPersoneli(String ptpAd, String ptpSoyad, double satisTutari,
			double prim) {
		super(ptpAd, ptpSoyad, 500.0);
		this.satisTutari = satisTutari;
		this.primYuzdesi = prim;
	}

}
