package com.example.swep2.vorlesungsbeispiele.JC12_GenericInterface;

public class GenericInterfaceProgramm {

	public static void main(String[] args) {
	
		KonkreteKlasse o1 = new KonkreteKlasse(3);
		o1.methode1(2);
		o1.methode2();
		GenericKlasse<String>  o2 = new GenericKlasse<String>("4.375"); 
		o2.methode1("2.123");
		o2.methode2();
	}
}
