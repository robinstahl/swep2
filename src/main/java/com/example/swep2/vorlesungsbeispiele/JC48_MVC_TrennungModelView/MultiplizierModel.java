package com.example.swep2.vorlesungsbeispiele.JC48_MVC_TrennungModelView;

import java.math.BigInteger;

public class MultiplizierModel {

	// Zustand der Berechnung  (hier nur ein einzelner Wert)
	private BigInteger aktuellerWert;
	
	MultiplizierModel() {
		reset();
	}
	
	public void setzeWert(BigInteger wert) {
		aktuellerWert = wert;
	}
	
	public void reset() {
		aktuellerWert = new BigInteger("1");
	}
	
	public void multipliziere(BigInteger bInt){
		aktuellerWert = aktuellerWert.multiply(bInt);
		System.out.println(aktuellerWert);
	}
}
