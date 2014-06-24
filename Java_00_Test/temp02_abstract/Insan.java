package temp02_abstract;

public class Insan extends Canli {

	private int yas;

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	@Override
	public void yuru() {
		System.out.println("On adim ileri gidildi.");

	}

}
