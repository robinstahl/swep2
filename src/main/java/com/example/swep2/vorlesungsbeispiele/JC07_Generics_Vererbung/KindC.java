package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;


public class KindC<U> extends ElternA<Integer> {
	public void methodeC(U u){
		System.out.println("In Methode methodeC mit Wert " + u);
	}
}
