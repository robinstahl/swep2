package com.example.swep2.vorlesungsbeispiele.JC02_AbstrakteKlasse;


public class Hauptprogramm {

	public static void main(String[] args) {

		//Hochschulangehoeriger k1 = new Hochschulangehoeriger();
		
		Hochschulangehoeriger[] h = new Hochschulangehoeriger[4];
		h[0] = new Student("Maier", "Hans", 12345);
		h[1] = new Professor("Hagel", "Georg", 34567);
		h[2] = new Student("Schmidt", "Paul", 34234);
		h[3] = new Professor("Müller", "Erich", 76543);
		
		for (Hochschulangehoeriger hsa : h){
			System.out.println(hsa);
		}
	}
}
