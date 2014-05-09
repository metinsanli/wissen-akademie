package com.objectSerial;

public class CreateSequentialFileTest {

	public static void main(String[] args) {
		CreateSequentialFile application = new CreateSequentialFile();

		application.open();
		application.addRecords();
		application.closeFile();
	}

}
