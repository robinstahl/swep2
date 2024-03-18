package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;


public class KindD extends ElternA<Byte>{
	public void methodeD(double d){
		System.out.println("In Methode methodeD mit Wert " + d);
	}
}
