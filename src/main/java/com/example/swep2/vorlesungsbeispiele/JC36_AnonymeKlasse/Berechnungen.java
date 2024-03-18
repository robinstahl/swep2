package com.example.swep2.vorlesungsbeispiele.JC36_AnonymeKlasse;

// Berechnungen nutzt Strategie-Entwurfsmuster!
// Hier wird der Methode erstelleWertetafel eine Strategie m übergeben.
// Was berechnet wird, weiss die Methode erstelleWertetafel nicht!

public class Berechnungen {
	public void erstelleWertetabelle(IIntMethode m){
		for (int i = 0; i < 11; i++){
			System.out.println(i + " -> " + m.berechne(i));
		}
	}
}
