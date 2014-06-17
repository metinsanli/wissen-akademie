package com.dunya.canlilar;

public class Hayvan {

	protected String isim;
	protected boolean yasiyor = true;

	public Hayvan() {
		System.out.println("Ben bir canliyim");
	}

	public void hareketEt() {
		System.out.println("Canli hareket ediyor!!!");
	}

	public void avla() {
		this.yasiyor = false;
	}

	public boolean getYasiyor() {
		return yasiyor;
	}

}
