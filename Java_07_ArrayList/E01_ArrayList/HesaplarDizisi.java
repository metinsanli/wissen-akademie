package E01_ArrayList;

import java.util.ArrayList;

public class HesaplarDizisi {

	public static void main(String[] args) {
		ArrayList<Hesap> hesaplar = new ArrayList<Hesap>();
		Hesap[] islemdizisi = new Hesap[4];

		for (int i = 0; i < 4; i++)
			islemdizisi[i] = new Hesap();

		islemdizisi[3].topla(3, 4);

		hesaplar.add(new Hesap());
		hesaplar.add(new Hesap());
		System.out.print(hesaplar.get(0).topla(3, 4));
		System.out.printf(" %s", islemdizisi[3].topla());
		
	}

}