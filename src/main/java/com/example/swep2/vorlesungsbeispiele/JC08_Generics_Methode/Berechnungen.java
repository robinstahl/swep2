package com.example.swep2.vorlesungsbeispiele.JC08_Generics_Methode;

import com.example.swep2.vorlesungsbeispiele.JC06_Generics.Punkt;

public class Berechnungen {
	
	
	public <T> void vertauschePunkte(Punkt<T> p1, Punkt<T> p2){
		
		Punkt<T> hilf = p1;
		p1 = p2;
		p2 = hilf;
		System.out.println("in der Methode:");
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		System.out.println("Ende Methode");
		
	}
}
		
	













		
//		T hilfX = p1.getX();
//		T hilfY = p1.getY();
//		
//		p1.setX(p2.getX());
//		p1.setY(p2.getY());
//		
//		p2.setX(hilfX);
//		p2.setY(hilfY);
//		
//	}
//}




















/*
		T hilfX;
		T hilfY;
		
		hilfX = p1.getX();
		hilfY = p1.getY();
		
		p1.setX(p2.getX());
		p1.setY(p2.getY());
		
		p2.setX(hilfX);
		p2.setY(hilfY);
	
		// Problem: clone() funktioniert mit Generics nicht!!!
		// Compiler meldet, dass clone() nicht fuer Typ T definiert ist. 

	}

}
*/
