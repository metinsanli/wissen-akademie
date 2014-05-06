import java.util.ArrayList;

public class Oyun {

	public String oyunAdi;
	public String oyuncuSayisi;
	public Double topYariCap;
	public Top oyunTopu;
	public Ball gameBall;
	ArrayList<Oyuncu> oyuncular = new ArrayList<Oyuncu>();

	public Oyun(String oyun, Double topYariCap) {
		this.oyunAdi = oyun;
		this.topYariCap = topYariCap;
		oyunTopu = new Top(topYariCap, this);
		gameBall = new Ball(topYariCap);
	} // end constructor

	// INNER CLASS "BALL"
	public class Ball {
		public String marka;
		public Double hacim;
		public Double agirlik;
		public String oyun = Oyun.this.oyunAdi;

		public Ball(double yariCap) {
			double r = yariCap;
			this.hacim = 4 / 3 * Math.PI * (r * r * r);
		} // end constructor

	} // end class Ball

} // end class Oyun
