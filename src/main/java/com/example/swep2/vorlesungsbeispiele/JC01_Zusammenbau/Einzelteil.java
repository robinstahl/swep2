package com.example.swep2.vorlesungsbeispiele.JC01_Zusammenbau;

public class Einzelteil extends Komponente {
	
	private int fertigungskosten; // in Cent

	public Einzelteil(int fk) {
		this.fertigungskosten = fk;
	}
	
	// Berechnet die Fertigungskosten fuer ein Einzelteil in Cent
	@Override
	public int berechneFertigungskosten() {
		return this.fertigungskosten;
	}

	// Berechnet die Herstellkosten fuer ein Einzelteil in Cent
	@Override
	public int berechneHerstellkosten() {
		// Herstellkosten sind Fertigungskosten, da keine Montagekosten
		return this.fertigungskosten;
	}
}
