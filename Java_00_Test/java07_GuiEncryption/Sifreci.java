package java07_GuiEncryption;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.ArrayList;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

@SuppressWarnings("all")
public class Sifreci {

	private static final String ALGO = "AES";
	private static byte[] keyValue = null;
	private String sifreli;

	public Sifreci(String sifre, String sifrelenecek) throws Exception {
		for (int i = 0; i < sifrelenecek.length(); i++) {
			int y = keyValue.length;
		}
		sifreli = encrypt(sifre);

	} // end constructor DEFAULT

	public static String encrypt(String Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		//Object[] tmp = keyValue.length;
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

	private static byte[] cevirByte(String keyValue) throws UnsupportedEncodingException {
		return keyValue.getBytes(keyValue);
	} // end method setkeyValue()

	public static void main(String[] args) throws Exception {
		new Sifreci("1234567", "Bu ne dunya kardesim");
	}

} // END CLASS