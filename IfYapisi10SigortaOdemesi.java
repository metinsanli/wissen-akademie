import java.util.Scanner;

public class IfYapisi10SigortaOdemesi {
	public static void main(String[] args) {
		Scanner sayiGiris = new Scanner(System.in);
		Scanner yaziGiris = new Scanner(System.in);
		int odenecekTutar = 0, yas;
		String isDurumu, istIcDis, ayaktaYatakli;

		System.out.printf("Yasiniz\t\t\t 18-60 \t> ");
		yas = sayiGiris.nextInt();
		System.out.printf("Istanbul Ici/Disi\t\tI/D > ");
		istIcDis = yaziGiris.next().toLowerCase();
		System.out.printf("Tedavi sekli (Ayakta/Yatakli)\tA/Y > ");
		ayaktaYatakli = yaziGiris.next().toLowerCase();
		System.out.printf("Is durumu (Calisan/Bagimli)\tC/B > ");
		isDurumu = yaziGiris.next().toLowerCase();

		if (yas <= 60 && yas >= 51) { // 51 - 60 YAS ARASI
			if (istIcDis == "i") { // ISTANBUL IC
				if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=0;}
 
				} else if (istIcDis == "d") {   // ISTANBUL DIS
					if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=775;}
				} // end if istanbul
			} // end if 51-60 yas
		
		if (yas <= 50 && yas >= 36) { // 36 - 50 YAS ARASI
			if (istIcDis == "i") {
				if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=0;}
				 // END ISTANBUL IC
				} else if (istIcDis == "d") { 
					if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=0;}
				}  // END ISTANBUL DIS
			} // END 36 - 50 YAS ARASI
		
		if (yas <= 35 && yas >= 18) { // 18 - 35 YAS ARASI
			if (istIcDis == "i") {
				if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
				if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=0;}
				 // END ISTANBUL IC
				} else if (istIcDis == "d") { 
					if ((ayaktaYatakli == "a") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "a") && (isDurumu == "b")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "c")) {odenecekTutar=0;}
					if ((ayaktaYatakli == "y") && (isDurumu == "b")) {odenecekTutar=0;}
				}  // END ISTANBUL DIS
			} // END 18 - 35 YAS ARASI


		System.out.printf("ODENECEK SIGORTA TUTARI = %d TL.\n", odenecekTutar);
		sayiGiris.close();
		yaziGiris.close();
	} // end main
} // end class