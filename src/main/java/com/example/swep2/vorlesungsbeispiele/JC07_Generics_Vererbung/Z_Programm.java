package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;

public class Z_Programm {

	public static void main(String[] args) {
		Z_B<String> zb = new Z_B<String>(1,"Hallo");
		System.out.println(zb);
		zb.methodeA();
		
	}

}
