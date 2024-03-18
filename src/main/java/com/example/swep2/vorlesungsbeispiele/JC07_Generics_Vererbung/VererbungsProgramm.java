package com.example.swep2.vorlesungsbeispiele.JC07_Generics_Vererbung;


public class VererbungsProgramm {


	public static void main(String[] args) {
	
		ElternA<Double> eA = new KindB<Double>();
		eA.methodeA(4.5); // Hier kann nur fuer eA die methodeA(Double) verwendet werden
		
		KindB<Double> kB = (KindB<Double>)eA;
	
		// nach der Typkonvertierung steht auch methodeB(Double) zur Verfuegung
		kB.methodeB(3.4);
		kB.methodeA(3.0);
//System.exit(0);
		KindC<Double> kC = new KindC<Double>();
		kC.methodeA(4);   // Hier ist die Signatur methodeA(Integer)
		kC.methodeC(2.5); // und methodeC(Double)
	
		ElternA<Integer> eAA = (ElternA<Integer>) kC;
		// nach der Typkonvertierung zur Basisklasse steht lediglich
		// methodeA(Integer) zur Verfuegung
		eAA.methodeA(5); 
		
//System.exit(0);
		KindD kD = new KindD();
		kD.methodeA((byte)123);
		kD.methodeD(7.8);
		
		ElternA<Byte> eAAA = (ElternA<Byte>) kD;
		eAAA.methodeA((byte)111);
	}
}
