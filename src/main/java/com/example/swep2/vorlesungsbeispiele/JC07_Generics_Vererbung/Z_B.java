package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;

public class Z_B<T> extends Z_A {
	private T zahl;
	public Z_B(int init_1, T init_2){
		super(init_1);
		zahl = init_2;
	}
	
	public String toString(){
		return super.toString()+", "+zahl;
	}

}
