package temp02_abstract;

public class Calistir {

	public static void main(String[] args) {

		Insan sercan = new Insan();
		sercan.setAd("Sercan");
		sercan.setYas(22);
		Canli seco = (Insan) sercan;
		seco.getAd();
		System.out.println(((Insan) seco).getYas());
	}

}
