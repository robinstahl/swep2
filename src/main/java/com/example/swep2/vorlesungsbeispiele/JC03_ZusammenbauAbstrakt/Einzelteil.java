package com.example.swep2.vorlesungsbeispiele.JC03_ZusammenbauAbstrakt;

public class Einzelteil extends Komponente {
	
	private int fertigungskosten;

	public Einzelteil(int fk) {
		this.fertigungskosten = fk;
	}
	
	// Berechnet die Herstellkosten fuer ein Einzelteil in Cent
	@Override
	public int berechneHerstellkosten() {
		return this.fertigungskosten;
	}
}
