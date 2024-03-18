package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;

public class KindB<S> extends ElternA<S>{	
	public void methodeB(S s){
		System.out.println("In Methode methodeB mit Wert " + s);
	}
}
