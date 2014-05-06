public class Top {

	public String marka;
	public Double hacim;
	public Double agirlik;
	public Oyun oyun;

	public Top(double yariCap, Oyun oyun) {
		double r = yariCap;
		this.hacim = 4 / 3 * Math.PI * (r * r * r);
		this.oyun = oyun;
	} // end constructor

}
