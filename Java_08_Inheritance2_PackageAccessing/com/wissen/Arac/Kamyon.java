package com.wissen.Arac;

public class Kamyon extends Arac {

	int defaultKamyon;
	private int privateKamyon;
	protected int protectedKamyon;
	public int publicKamyon;

	public Kamyon() {
		this.defaultArac = 0;
		this.protectedArac = 0;
		this.publicArac = 0;
	}
	
	public Kamyon (int o) {
		this.defaultArac = 0;
	}
}
