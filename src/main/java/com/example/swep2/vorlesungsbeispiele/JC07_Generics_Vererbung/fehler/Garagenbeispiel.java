package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung.fehler;

public class Garagenbeispiel {

	public static void main(String[] args) {
		Fahrzeug fzg = new Fahrzeug();
		Auto auto = new Auto();
		fzg = auto;
		
		Garage<Fahrzeug> gf = new Garage<Fahrzeug>();
		Garage<Auto> ga = new Garage<Auto>();
		// Fehler, da nicht in Vererbungsbeziehung:
		//gf = ga;
	}

}
