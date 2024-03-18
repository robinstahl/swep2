package com.example.swep2.vorlesungsbeispiele.JC06_Generics;

public class PunkteProgramm {

	public static void main(String[] args) {
		Punkt<Integer> pint1 = new Punkt<Integer>(2, 3);
		Punkt<Integer> pint2 = new Punkt<>(4, 5);//Diamant-Operator (seit Java 1.7)
		System.out.println("Punkte " + pint1 + " und " + pint2 + " .");
		
		Punkt<Double> pdoub1 = new Punkt<Double>(2.0, 3.0);
		Punkt<Double> pdoub2 = new Punkt<>(4.0, 5.0);//Diamant-Operator
		System.out.println("Punkte " + pdoub1 + " und " + pdoub2 + " .");
		
		// Unsinnige Verwendung:
		Punkt<String> pstring = new Punkt<String>("1","Hallo");
		System.out.println("Sonderpunkt:" + pstring);
	}
}
