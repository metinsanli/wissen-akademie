package Original;
import java.util.Scanner;

public class Validate {

	public static void main(String[] args) {

		// Get User Input
		Scanner scanner = new Scanner(System.in);
		System.out.printf("\nPlease enter first name\t> ");
		String firstName = scanner.nextLine();
		System.out.printf("\nPlease enter last name\t> ");
		String lastName = scanner.nextLine();
		System.out.printf("\nPlease enter adress\t> ");
		String adress = scanner.nextLine();
		System.out.printf("\nPlease enter city\t> ");
		String city = scanner.nextLine();
		System.out.printf("\nPlease enter state\t> ");
		String state = scanner.nextLine();
		System.out.printf("\nPlease enter zip\t> ");
		String zip = scanner.nextLine();
		System.out.printf("\nPlease enter phone\t> ");
		String phone = scanner.nextLine();

		// Validate User Input and Display Error Message
		System.out.printf("\nValidate Result :");

		if (!ValidateInput.validateFirstName(firstName))
			System.out.printf("\nInvalid First Name!");
		else if (!ValidateInput.validateFirstName(lastName))
			System.out.printf("\nInvalid Last Name!");
		else if (!ValidateInput.validateAdress(adress))
			System.out.printf("\nInvalid Adress!");
		else if (!ValidateInput.validateCity(city))
			System.out.printf("\nInvalid City!");
		else if (!ValidateInput.validateState(state))
			System.out.printf("\nInvalid State!");
		else if (!ValidateInput.validateZip(zip))
			System.out.printf("\nInvalid Zip!");
		else if (!ValidateInput.validatePhone(phone))
			System.out.printf("\nInvalid Phone Number!");
		else
			System.out.printf("\nValid Input. Thank you :)!");

		scanner.close();
	} // end main()

} // end class