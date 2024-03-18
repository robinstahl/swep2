package com.example.swep2.vorlesungsbeispiele.JC10_Generics_UpperBound;


public class UpperBoundProgramm {

	public static void main(String[] args) {

		Punkt<Integer> p1 = new Punkt<Integer>(2,3);
		Punkt<Double> p2 = new Punkt<Double>(3.0,4.0);
		Punkt<Integer> p3 = new Punkt<Integer>(1,4);
		// Nur durch die Wildcard der Methode abstand(Punkt<?> p) kann der
		// Methodenaufruf eines Objektes der Klasse Punkt<Integer>
		// mit Argumenttyp Punkt<Double> erfolgen. Waere die Signatur
		// abstand(Punkt<T> p) ginge dies nicht!!!
		System.out.println(p1.abstand(p2));
	}
	
}
