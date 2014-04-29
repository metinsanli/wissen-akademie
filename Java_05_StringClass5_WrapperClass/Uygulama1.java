/**
 * parseInt() ve parseDouble() methodlari ile String bir ifadenin icinden uygun
 * sayisal degerleri integer veya double degerlere donusturulebilir.
 * 
 */

public class Uygulama1 {

	public static void main(String[] args) {

		String kayit = "metin sanli 34-5-1212 6 5.5";
		String[] parcalar = kayit.split(" ");
		System.out.println("Parca adedi = " + parcalar.length);
		int no = Integer.parseInt(parcalar[parcalar.length - 2]);
		double oran = Double.parseDouble(parcalar[parcalar.length - 1]);
		System.out.println("Sonuc = " + (no * oran));

	}

}
