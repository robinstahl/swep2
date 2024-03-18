package com.example.swep2.vorlesungsbeispiele.JC03_ZusammenbauAbstrakt;

public class Zusammenbau extends Komponente {

	private final int maxTeile = 100;
	private Komponente[] teile = new Komponente[maxTeile];
	private int numTeile = 0;
	private int montagekosten;
	
	public Zusammenbau(int montagekosten){
		this.montagekosten = montagekosten;
	}
	
	public boolean hinzufuegen(Komponente k) {
		if(numTeile < maxTeile ) {
		    teile[numTeile++] = k;  
		    return  true;
		}
		else {
			return false;
		}	
	}
	
	// Berechnet die Herstellkosten fuer einen Zusammenbau in Cent
	@Override
	public int berechneHerstellkosten() {
		
		// Uebergebe die Aufgabe die Herstellkosten zu berechnen 
		// an die untergeordneten Teilbaeume weiter und bilde 
		// abschliessend die Summe aus den Teilbaumbetraegen.
		int sum = montagekosten;
		for(int i=0; i<numTeile; i++) {
			sum += teile[i].berechneHerstellkosten();
		}
		
		return sum;
	}
}
