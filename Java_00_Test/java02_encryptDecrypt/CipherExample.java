package java02_encryptDecrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class CipherExample {

	public static void main(String[] args) {
		try {
			String key = "12345678"; // needs to be at least 8 characters for DES

			FileInputStream fis = new FileInputStream("./src/java02_encryptDecrypt/original.txt");
			FileOutputStream fos = new FileOutputStream("./src/java02_encryptDecrypt/encrypted.txt");
			encrypt(key, fis, fos);

			FileInputStream fis2 = new FileInputStream("./src/java02_encryptDecrypt/encrypted.txt");
			FileOutputStream fos2 = new FileOutputStream("./src/java02_encryptDecrypt/decrypted.txt");
			decrypt(key, fis2, fos2);

		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	} // end main()

	public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	} // end method encrypt()

	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	} // end method decrypt()

	public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

		DESKeySpec dks = new DESKeySpec(key.getBytes()); // sifre byte[] cevrilip DESKeySpec sinifindan nesne yaratiliyor dks
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); // SecretKeyFactory sinifindan "DES" algoritmasina uygun nesne yaratiliyor. skf
		SecretKey desKey = skf.generateSecret(dks); // skf'den dks parametresi alinarak SecretKey siifindan nesne yaratiliyor. desKey
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	} // end method encryptOrDecrypt()

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	} // end method doCopy()

} // END CLASS