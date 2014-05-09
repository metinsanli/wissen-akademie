package com.objectSerial;

import java.io.Serializable;

@SuppressWarnings("all")
public class AccountRecordSerializable implements Serializable {

	private int account;
	private String firstName, lastName;
	private double balance;

	public AccountRecordSerializable() {
		this(0, "", "", 0.0);
	} // end constructor DEFAULT

	public AccountRecordSerializable(int acct, String first, String last, double bal) {
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
	} // end constructor

	private void setAccount(int acct) {
		account = acct;
	} // end method setAccount()

	private void setFirstName(String first) {
		firstName = first;
	} // end method setFirstName()

	private void setLastName(String last) {
		lastName = last;
	} // end method setLastName()

	private void setBalance(double bal) {
		balance = bal;
	} // end method setBalance()

	public int getAccunt() {
		return account;
	} // end method getAccunt()

	public String getFirstName() {
		return firstName;
	} // end method getFirstName()

	public String getLastName() {
		return lastName;
	} // end method getLastName()

	public double getBalance() {
		return balance;
	} // end method getBalance()

} // END CLASS