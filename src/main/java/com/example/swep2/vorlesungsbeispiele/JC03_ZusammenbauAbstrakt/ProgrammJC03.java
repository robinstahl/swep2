package com.example.swep2.vorlesungsbeispiele.JC03_ZusammenbauAbstrakt;

public class ProgrammJC03 {

	public static void main(String[] args) {
		
		Einzelteil schraube = new Einzelteil(50);
		Zusammenbau verschraubung = new Zusammenbau(0);
		for(int i=0; i<5; i++)
		    verschraubung.hinzufuegen(schraube);
		Einzelteil felge = new Einzelteil(5000);
		Einzelteil reifen = new Einzelteil(8000);
		Zusammenbau rad = new Zusammenbau(4000);
		rad.hinzufuegen(felge);
		rad.hinzufuegen(reifen);
		rad.hinzufuegen(verschraubung);
		Zusammenbau bereifung = new Zusammenbau(0);
		for(int i=0; i<4; i++) {
		    bereifung.hinzufuegen(rad);
		}
		// Herstellkosten fuer die Bereifung eines Autos ermitteln:
		System.out.println("Herstellkosten der Bereifung: " 
		    +  bereifung.berechneHerstellkosten()/100);    
	}
}
