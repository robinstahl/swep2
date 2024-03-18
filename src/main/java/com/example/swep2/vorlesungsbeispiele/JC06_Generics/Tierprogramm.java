package com.example.swep2.vorlesungsbeispiele.JC06_Generics;

public class Tierprogramm {

	@SuppressWarnings(value = {"unchecked", "rawtypes"})
	public static void main(String[] args) {
		Stall<Kuh> stall = new Stall<>(new Kuh());
		Kuh kuh = stall.getBewohner();
		
		Stall myStall = stall;
		myStall.setBewohner(new Schaf());
		
		kuh = stall.getBewohner();
		System.out.println(kuh);

	}

}
