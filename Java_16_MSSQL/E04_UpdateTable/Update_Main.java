package E04_UpdateTable;

import E03_RetrieveData.Retrieve_Data;

public class Update_Main {

	public static void main(String[] args) throws Exception {

		new Update().modifyPrices(1.05f);
		Retrieve_Data.main(args); // Diger uygulamanin main() methodunu cagiriyor.

	} // end method main()

} // END CLASS