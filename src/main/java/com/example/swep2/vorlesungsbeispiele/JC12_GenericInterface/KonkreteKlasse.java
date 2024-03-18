package com.example.swep2.vorlesungsbeispiele.JC12_GenericInterface;

public class KonkreteKlasse implements GenInterface<Integer>{
	Integer meinWert;

	public KonkreteKlasse(Integer i){
		meinWert = i;
		methode1(meinWert);
		methode2();
	}

	public void methode1(Integer i){
		System.out.println("Methode1 von KonkreteKlasse, Wert "+ i);
	}
	
	public void methode2(){
		System.out.println("Methode2 von KonkreteKlasse.");
	}
	
}
