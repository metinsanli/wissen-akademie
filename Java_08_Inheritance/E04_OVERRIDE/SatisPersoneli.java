package E04_OVERRIDE;

public class SatisPersoneli extends Personel {

	public double satisTutari;
	public double primYuzdesi;

	public SatisPersoneli() {
	} // end constructor DEFAULT

	public SatisPersoneli(String ptpAd, String ptpSoyad, double satisTutari, double prim) {
		super(ptpAd, ptpSoyad, 500.0);
		this.satisTutari = satisTutari;
		this.primYuzdesi = prim;
	} // end constructor

	public void setSatisTutari(double satisTutari) {
		if (satisTutari >= 0)
			this.satisTutari = satisTutari;
		else
			System.out.println("Tutar pozitif olmali!");
	} // end method setSatisTutari()

	@Override
	public double hakEdis() {
		System.out.println("Satis Personeli Hakedis : ");
		return super.getMass() + (this.satisTutari * (1 + primYuzdesi));
	} // end method hakEdis()

} // end class
