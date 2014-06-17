package E01_ObjectSerialization1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@SuppressWarnings("all")
public class ReadSequentialFile {

	private ObjectInputStream input;

	public void openFile() {
		try {
			input = new ObjectInputStream(new FileInputStream("./src/E01_ObjectSerialization1/clients.ser"));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		}
	} // end method openFile()

	public void readRecords() {
		AccountRecordSerializable record;
		System.out.printf("%-10s%-12s%-12s%-10s\n", "Account", "First Name", "Last Name", "Balance");
		try {
			while (true) {
				record = (AccountRecordSerializable) input.readObject();
				// display record contents
				System.out.printf("%-10s%-12s%-12s%-10.2f\n", record.getAccunt(), record.getFirstName(), record.getLastName(), record.getBalance());
			}
		} catch (EOFException e) {
			return;
		} catch (ClassNotFoundException classnotfoundex) {
			System.err.println("Unable to create object.");
		} catch (IOException ieEx) {
			System.err.println("Error during reading from file.");
		}
	} // end method readRecords()

	public void closeFile() {
		try {
			if (input != null)
				input.close();
			System.exit(0);
		} catch (IOException e) {
			System.err.println("Error closing file.");
			System.exit(1);
		}
	} // end method closeFile()

} // END CLASS