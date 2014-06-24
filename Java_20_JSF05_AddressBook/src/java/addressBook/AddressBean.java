/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;

/**

 @author wissen1
 */
@ManagedBean(name = "addressBean")
public class AddressBean {

    //Class variables
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    final String URL = "jdbc:sqlserver://10.0.0.11:1433"
            + ";databasename=dbAddressBook"
            + ";user=test;password=D3n3m3123";

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getStreet () {
        return street;
    }

    public void setStreet (String street) {
        this.street = street;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public String getZipcode () {
        return zipcode;
    }

    public void setZipcode (String zipcode) {
        this.zipcode = zipcode;
    }

    public String save () throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(URL);
//Bağlantının sağlanıp sağlanmadığını kontrol et
        if (connection == null) {
            throw new SQLException("Bağlantı Kurulamadı");
        }
        try {
//Veri eklemek için bir PreparedStatement oluştur.
            PreparedStatement addEntry = connection.prepareStatement(
                    "INSERT INTO ADDRESSES "
                    + "(FIRSTNAME,LASTNAME,STREET,CITY,STATE,ZIP)"
                    + "VALUES ( ?, ?, ?, ?, ?, ? )");

            //PreparedStatement'ın argumanlarını belirt
            addEntry.setString(1, getFirstName());
            addEntry.setString(2, getLastName());
            addEntry.setString(3, getStreet());
            addEntry.setString(4, getCity());
            addEntry.setString(5, getState());
            addEntry.setString(6, getZipcode());

            addEntry.executeUpdate(); // insert the entry 
        } finally {
            connection.close();
        }

        //burada işlem bittikten sonra
//yönlendirilmesini istediğimiz sayfa adını return değeri olarak yazarız.
        return "index";
    }
//Bu method "address" methodu olarak index.xhtlm sayfasından çağırılacak. 

    public ResultSet getAddress () throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(URL);

        try {
            // create a PreparedStatement to insert a new address book entry
            PreparedStatement getAddresses = connection.prepareStatement(
                    "SELECT FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP "
                    + "FROM ADDRESSES ORDER BY LASTNAME, FIRSTNAME");

            CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(getAddresses.executeQuery());
            return rowSet;
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally

    }

}
