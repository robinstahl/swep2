package com.example.swep2.vorlesungsbeispiele.JC09_Generics_Wildcard;

import com.example.swep2.vorlesungsbeispiele.JC06_Generics.Punkt;


public class WildcardProgramm {

	public static void punktAusgeben(Punkt<?> punkt) {
		System.out.println("Punkt:" + punkt);
	}
	
	public static void main(String[] args) {
		//Punkt<Integer>[] pListe = new Punkt<Integer>[4];
		
		// Man kann hier Wildcard auch weglassen
		//Punkt[] punkte = new Punkt[4];
		
		// Bitte in der Klausur immer mit angeben!
		Punkt<?>[] punkte = new Punkt<?>[4]; 
		
		punkte[0] = new Punkt<Integer>(2,3);
		punkte[1] = new Punkt<Double>(4.0,5.0);
		punkte[2] = new Punkt<String>("6","Hallo");
		punkte[3] = new Punkt<Byte>((byte)2,(byte)3);
		
		for (Punkt<?> x : punkte){
			punktAusgeben(x);
		}
	}
}
