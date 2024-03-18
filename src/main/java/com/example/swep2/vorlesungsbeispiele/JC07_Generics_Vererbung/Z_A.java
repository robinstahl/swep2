package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;

public class Z_A {
	private int zahl;
	public Z_A(int initialwert){
		zahl = initialwert;
	}
	public void methodeA(){
		System.out.println("Z_A methodeA");
	}
	public String toString(){
		return ""+zahl;
	}
}
