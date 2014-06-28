
@SuppressWarnings("all")
public class IsParcacik implements Runnable {

    public static void main(String args[]) {

        IsParcacik isBir = new IsParcacik("BIRINCI IS", 2100000000);
        IsParcacik isIki = new IsParcacik("IKINCI IS", 2100000000);
        IsParcacik isUc = new IsParcacik("UCUNCU IS", 2100000000);

        Thread thread1 = new Thread(isBir, "");
        Thread thread2 = new Thread(isIki);
        Thread thread3 = new Thread(isUc);

        // THREAD ler 1,2,3 sirali olarak baslatiliyor.
        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * Her bir thread sonlandiginda terminale "BITTI!" mesajı yazacaktir.
         * Fakat; bitis sirasi program her calistirildiginda baslangic sirasi
         * ile ayni olmayabilir. Bu farkli siralama rastgelelikten degil CPU nun
         * dongu islemlerini ne kadar kisa surede sonlandirabildigiyle
         * ilgilidir.
         */
    }

    private String mesaj;
    private int dongu;

    public IsParcacik(String mesaj, int dongu) {
        this.mesaj = mesaj;
        this.dongu = dongu;
    }

    @Override
    public void run() {
        for (int i = 0; i > dongu; i++) {
        }
        System.out.printf("\n%s BITTI.", mesaj);
    }

}
