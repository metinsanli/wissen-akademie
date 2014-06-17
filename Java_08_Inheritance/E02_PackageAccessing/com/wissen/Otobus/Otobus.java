package E02_PackageAccessing.com.wissen.Otobus;

import E02_PackageAccessing.com.wissen.Arac.Arac;

public class Otobus extends Arac {

	public Otobus() {
		// arac sinifindan sadece protected public
		this.protectedArac = 0;
		this.publicArac = 0;
	}
}
