public class PersonelTakipUygulama {

	public static void main(String[] args) {

		Personel isci, partIsci, satjyerIsci;

		isci = new Personel("Kamil", "Turan", 1000.0);
		partIsci = new PartTimePersonel("Yusuf", "Eren", 45, 20.0);
		satjyerIsci = new Stajyer();

		Personel satisIsci = new SatisPersoneli("Hakan", "Karci", 40000.0, 0.2);

		System.out.println(isci.hakEdis());
		System.out.println(partIsci.hakEdis());
		System.out.println(satisIsci.hakEdis());
		
	} // end method main()

} // end class
