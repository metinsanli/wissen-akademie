package SqlConnection2;

import SqlConnection.SqlConn_II_Retrieve_Data; // main() mehodunu cagirmak icin sinif import ediliyor

public class SqlConn_IV_Update_Main {

	public static void main(String[] args) throws Exception {

		new SqlConn_IV_Update().modifyPrices(1.05f);
		SqlConn_II_Retrieve_Data.main(args); // Diger uygulamanin main() methodunu cagiriyor.

	} // end method main()

} // END CLASS