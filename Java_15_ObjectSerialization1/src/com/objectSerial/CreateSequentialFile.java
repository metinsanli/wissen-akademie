package com.objectSerial;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

@SuppressWarnings("all")
public class CreateSequentialFile {

	private ObjectOutputStream output; // outputs data to file
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public void open() {
		try { // open file
			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
		} catch (IOException e) {
			System.err.println("Error opening file.");
		}
	} // end method open()

	public void addRecords() {
		AccountRecordSerializable record; // object to be written to file
		int accountNumber = 0;
		String firstName;
		String lastName;
		double balance;
		//
		// Scanner input = new Scanner(System.in);
		//
		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.",
				"On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl> z then press Enter");
		System.out.printf("%s\n%s", "Enter account number (>0), first name, last name and balance.", "?");
		int count = 0;
		while (true) {
			count++;
			System.out.printf("\nCount : %d", count);
			try {
				System.out.printf("\nAccount number\t>");
				accountNumber = Integer.parseInt(input.readLine());
				if (accountNumber > 0) {
					System.out.printf("First name\t>");
					firstName = input.readLine();
					System.out.printf("Last name\t>");
					lastName = input.readLine();
					System.out.printf("Balance\t\t>");
					balance = Double.parseDouble(input.readLine());
					// create new record
					record = new AccountRecordSerializable(accountNumber, firstName, lastName, balance);
					output.writeObject(record);
				} else {
					System.out.println("exited.");
					break;
				}
			} catch (IOException ioException) {
				System.err.println("Error writing to file.");
				return;
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				try {
					input.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // end try-catch block
		} // end while
	} // end method addRecords

	public void closeFile() {
		try {
			output.close();
			System.exit(0);
		} catch (IOException ioException) {
			System.err.println("Error closing file.");
			System.exit(0);
		}
	} // end method closeFile()

} // END CLASS