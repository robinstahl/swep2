package com.example.swep2.vorlesungsbeispiele.JC05_Generics_Motivation;

public class GenericsMotivation {

	public static void main(String[] args) {
		
		PunktInteger pint1 = new PunktInteger(2, 3);
		PunktInteger pint2 = new PunktInteger(4, 5);
		System.out.println("Punkte " + pint1 + " und " + pint2 + " .");
		
		PunktDouble pdoub1 = new PunktDouble(2.1, 3.2);
		PunktDouble pdoub2 = new PunktDouble(3.9, 5.4);
		System.out.println("Punkte " + pdoub1 + " und " + pdoub2 + " .");
	}
}
