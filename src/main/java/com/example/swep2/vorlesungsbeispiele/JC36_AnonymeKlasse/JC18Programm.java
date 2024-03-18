package com.example.swep2.vorlesungsbeispiele.JC36_AnonymeKlasse;

public class JC18Programm {

	public static void main(String[] args) {
		Berechnungen b = new Berechnungen();
		// Erzeuge Strategie!
		Kubik strategie_k = new Kubik();
		System.out.println("Kubische Werte:");
		// Ausgabe ist abhaengig von der Strategie
		b.erstelleWertetabelle(strategie_k);

		System.out.println("Quadratische Werte:");
		// als Parameteruebergabe wird das Interface implementiert und die
		// Referenz auf das daraus erzeugte Objekt anonym uebergeben (d.h. es
		// existiert kein Klassenname fuer die Instanz)
		b.erstelleWertetabelle(new IIntMethode() {
			@Override
			public int berechne(int x) {
				return x * x;
			}
		});

	}
}
