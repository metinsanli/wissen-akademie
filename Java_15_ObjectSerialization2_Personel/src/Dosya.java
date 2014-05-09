import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Dosya {

	private ObjectOutputStream output;
	private ObjectInputStream input;

	public void yaz(ArrayList<Personel> personel) {
		try {
			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
			for (Personel p : personel)
				output.writeObject(p);
			output.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	} // end method yaz()

	public ArrayList<Personel> oku() {
		ArrayList<Personel> personeller = new ArrayList<Personel>();
		try {
			input = new ObjectInputStream(new FileInputStream("clients.ser"));
			while (true) {
				personeller.add((Personel) input.readObject());
			}
		} catch (EOFException e) {
			try {
				input.close();
			} catch (IOException e1) {
			}
			return personeller;
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		return personeller;
	} // end methof oku()

} // END CLASS