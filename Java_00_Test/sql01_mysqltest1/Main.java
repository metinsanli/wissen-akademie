package sql01_mysqltest1;

public class Main {
	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
	}

}