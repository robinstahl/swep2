package com.example.swep2.vorlesungsbeispiele.JC50_MVC_EinfuehrungController;

import java.math.BigInteger;

public class MultiplizierModel extends Subject {

	private BigInteger aktuellerWert;
	
	MultiplizierModel() {
		reset();
	}
	
	public void reset() {
		aktuellerWert = new BigInteger("1");
		benachrichtigen();
	}
	
	public void multipliziere(BigInteger bInt){
		aktuellerWert = aktuellerWert.multiply(bInt);
		benachrichtigen();
	}
	
	public BigInteger getAktuellerWert(){
		return aktuellerWert;
	}
}
