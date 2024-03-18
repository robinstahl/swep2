package com.example.swep2.vorlesungsbeispiele.JC36_AnonymeKlasse;


// Die Klasse Kubik transportiert lediglich die Methode
// berechne, die den eingegebenen Wert mit 3 potenziert.

public class Kubik implements IIntMethode {
	
	@Override
	public int berechne(int x){
		return x * x * x;
	}
}
