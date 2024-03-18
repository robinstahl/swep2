package com.example.swep2.vorlesungsbeispiele.JC11_BoundedWildcards;

public class BoundedWildcardProgramm {
	
	public static void main(String[] args) {
		
		WildcardMethoden wm = new WildcardMethoden();
		
		A a = new A();
		B b = new B();
		C c = new C();
		Node<A> nA = new Node<A>(a);
		Node<B> nB = new Node<B>(b);
		Node<C> nC = new Node<C>(c);
		

		wm.nurObjekteVonAZulassen(nA);
		wm.nurObjekteVonAZulassen(nB);
		wm.nurObjekteVonAZulassen(nC);

		//wm.nurObjekteVonBZulassen(nA); // Fehler
		wm.nurObjekteVonBZulassen(nB);
		wm.nurObjekteVonBZulassen(nC);
		
		wm.nurBasisklassenVonBZulassen(nA);
		wm.nurBasisklassenVonBZulassen(nB);
		//wm.nurBasisklassenVonBZulassen(nC); //geht nicht
	}
}
