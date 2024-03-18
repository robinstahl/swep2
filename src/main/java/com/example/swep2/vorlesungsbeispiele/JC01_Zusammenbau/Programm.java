package com.example.swep2.vorlesungsbeispiele.JC01_Zusammenbau;

public class Programm {

	public static void main(String[] args) {
		
		Einzelteil schraube = new Einzelteil(50);
		Zusammenbau schraubenSet = new Zusammenbau(0);
		for(int i=0; i<5; i++)
		    schraubenSet.hinzufuegen(schraube);
		Einzelteil felge = new Einzelteil(5000);
		Einzelteil reifen = new Einzelteil(8000);
		Zusammenbau rad = new Zusammenbau(4000);
		rad.hinzufuegen(felge);
		rad.hinzufuegen(reifen);
		rad.hinzufuegen(schraubenSet);
		Zusammenbau raederSet = new Zusammenbau(0);
		for(int i=0; i<4; i++) {
		    raederSet.hinzufuegen(rad);
		}
		// Fertigungskosten fuer die Räder eines Autos ermitteln:
		System.out.println("Fertigungskosten der Räder: " 
		    +  raederSet.berechneFertigungskosten()/100.0); 
		// Herstellkosten fuer die Räder eines Autos ermitteln:
		System.out.println("Herstellkosten der Räder: " 
			+  raederSet.berechneHerstellkosten()/100.0); 
	}
}
