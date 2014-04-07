public class ValidateInput {

	// Validate First Name
	public static boolean validateFirstName(String firstName) {
		return firstName.matches("[a-zA-Z][a-zA-Z]*");
	}

	// Validate Last Name
	public static boolean validateLastNamet(String lastName) {
		return lastName.matches("[a-zA-Z]+([ '-][a-zA-Z]+)*");
	}

	// Validate Adress
	public static boolean validateAdress(String adress) {
		return adress.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}

	// Validate City
	public static boolean validateCity(String city) {
		return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}

	// Validate State
	public static boolean validateState(String state) {
		return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
	}

	// Validate ZIP
	public static boolean validateZip(String zip) {
		return zip.matches("\\d{5}");
	}

	// Validate Phone
	public static boolean validatePhone(String phone) {
		return phone.matches("[1-9]\\d{2}[1-9]\\d{2}\\d{4}");
	}

} // end class