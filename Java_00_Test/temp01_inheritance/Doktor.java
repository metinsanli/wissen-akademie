package temp01_inheritance;

public class Doktor extends Insan {

	private String uzmanlikAlani;
	private String unvani;

	public Doktor() {
		super.setAd("Metin");
	}

	public String getUzmanlikAlani() {
		return uzmanlikAlani;
	}

	public void setUzmanlikAlani(String uzmanlikAlani) {
		this.uzmanlikAlani = uzmanlikAlani;
	}

	public String getUnvani() {
		return unvani;
	}

	public void setUnvani(String unvani) {
		this.unvani = unvani;
	}

}
