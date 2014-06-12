package E03_REGEX;

import java.util.Scanner;

public class Validate {

	public static void main(String[] args) {

		// Get User Input
		Scanner scanner = new Scanner(System.in);
		String firstName = "", lastName = "", adress = "", city = "", state = "", zip = "", phone = "";

		while (!ValidateInput.validateFirstName(firstName)) {
			System.out.printf("\nPlease enter first name\t> ");
			firstName = scanner.nextLine();
		}

		while (!ValidateInput.validateFirstName(lastName)) {
			System.out.printf("\nPlease enter last name\t> ");
			lastName = scanner.nextLine();
		}

		while (!ValidateInput.validateAdress(adress)) {
			System.out.printf("\nPlease enter adress\t> ");
			adress = scanner.nextLine();
		}

		while (!ValidateInput.validateCity(city)) {
			System.out.printf("\nPlease enter city\t> ");
			city = scanner.nextLine();
		}

		while (!ValidateInput.validateState(state)) {
			System.out.printf("\nPlease enter state\t> ");
			state = scanner.nextLine();
		}

		while (!ValidateInput.validateZip(zip)) {
			System.out.printf("\nPlease enter zip\t> ");
			zip = scanner.nextLine();
		}

		while (!ValidateInput.validatePhone(phone)) {
			System.out.printf("\nPlease enter phone\t> ");
			phone = scanner.nextLine();
		}

		// Validate User Input and Display Error Message
		System.out.printf("\nValidate Result :");

		if (!ValidateInput.validateFirstName(firstName) && !ValidateInput.validateFirstName(lastName) && !ValidateInput.validateAdress(adress) && !ValidateInput.validateCity(city) && !ValidateInput.validateState(state) && !ValidateInput.validateZip(zip) && !ValidateInput.validatePhone(phone))
			System.out.printf("\nValid Input. Thank you :)!");

		scanner.close();
	} // end main()
} // end class