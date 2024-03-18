package com.example.swep2.vorlesungsbeispiele.JC08_Generics_Methode;

import com.example.swep2.vorlesungsbeispiele.JC06_Generics.Punkt;

public class VertauschungsProgramm {
	
	public static void main(String[] args) {
		
		Punkt<Integer> p1 = new Punkt<Integer>(2,3);
		Punkt<Integer> p2 = new Punkt<Integer>(4,5);
		
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		
		Berechnungen b = new Berechnungen();
		b.vertauschePunkte(p1, p2);
		
		System.out.println("Vertauschen");
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
	System.exit(0);	
		// und das gleiche mit Double:
		Punkt<Double> p1_d = new Punkt<Double>(2.1,3.1);
		Punkt<Double> p2_d = new Punkt<Double>(4.2,5.2);
		
		System.out.println("P1: " + p1_d);
		System.out.println("P2: " + p2_d);
		
		b.vertauschePunkte(p1_d, p2_d);
		
		System.out.println("Vertauschen");
		System.out.println("P1: " + p1_d);
		System.out.println("P2: " + p2_d);
		
		
	}
}
