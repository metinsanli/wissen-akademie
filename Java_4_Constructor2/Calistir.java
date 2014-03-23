public class Calistir {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		DortIslem hesap1 = new DortIslem();
		System.out.printf("\nhesap1.topla()\t: %d", hesap1.topla());

		DortIslem hesap2 = new DortIslem(4, 2);
		System.out.printf("\nhesap1.topla()\t: %d", hesap1.topla());

		System.out.printf("\nhesap2.topla(8, 10)\t: %d", hesap2.topla(8, 10));
		System.out.printf("\nhesap1.topla()\t: %d", hesap1.topla());
		System.out.printf("\nhesap2.topla()\t: %d", hesap2.topla());
		System.out.printf("\nhesap1.topla(5, 6)\t: %d", hesap1.topla(5, 6));
		System.out.printf("\nhesap2.topla()\t: %d", hesap2.topla());

	} // end main

} // end class