package E04_OVERRIDE;

public class PartTimePersonel extends Personel {

	public int mesaiSaat;
	public double saatUcret;

	public PartTimePersonel() {
		super();
	} // end constructor DEFAULT

	public PartTimePersonel(String ptpAd, String ptpSoyad, int ptpMesai, double ptpSaatUcret) {
		super(ptpAd, ptpSoyad, 0);
		this.mesaiSaat = ptpMesai;
		this.saatUcret = ptpSaatUcret;
	} // end constructor

	public void setMesaiSaat(int saat) {
		if (saat >= 0)
			mesaiSaat = saat;
		else
			System.out.println("Mesai saati pozitif deger olmali!");
	} // end method setMesaiSaat()

	@Override
	public double hakEdis() {
		System.out.println("Part Time Personel Hakedis : ");
		return saatUcret * mesaiSaat;
	} // end method hakEdis()

} // end class
