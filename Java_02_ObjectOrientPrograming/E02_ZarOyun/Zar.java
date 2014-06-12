package E02_ZarOyun;
import java.util.Random;

public class Zar {

	public int deger;
	public String renk;

	public int zarAt() {
		Random rastgele = new Random();
		this.deger = rastgele.nextInt(6) + 1;
		return deger;
	} // end zarAt()

	public void renkAta(String renk) {
		this.renk = renk;
	} // end renkAta()

} // end class