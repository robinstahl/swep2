package com.example.swep2.vorlesungsbeispiele.JC49_MVC_EinfuehrungBeobachterMuster;

import java.math.BigInteger;

// AENDERUNG: Implementierung des IObservable-Interfaces
public class MultiplizierModel extends Subject {

	// Zustand der Berechnung (hier nur ein einzelner Wert)
	private BigInteger aktuellerWert;

	MultiplizierModel() {
		reset();
	}

	// In setzeWert() muss benachrichtige() für alle Beobachter aufgerufen
	// werden.
	// Die View ist ein angemeldeter Beobachter des Models
	public void setzeWert(BigInteger wert) {
		aktuellerWert = wert;
		// AENDERUNG: erzwinge eine Aktualisierung aller Beobachter
		benachrichtigen();
	}

	// In reset() muss benachrichtige() zum Aktualisieren aller Beobachter
	// aufgerufen werden.
	public void reset() {
		aktuellerWert = new BigInteger("1");
		// AENDERUNG: erzwinge eine Aktualisierung aller Beobachter
		benachrichtigen();
	}

	public void multipliziere(BigInteger bInt) {
		aktuellerWert = aktuellerWert.multiply(bInt);
		benachrichtigen();
	}

	// AENDERUNG: Das Beobachtermodell erfordert eine Methode getZustand() hier:
	public BigInteger getAktuellerWert() {
		return aktuellerWert;
	}
}
