package com.example.swep2.vorlesungsbeispiele.JC11_BoundedWildcards;


public class WildcardMethoden {


	// upper bound wildcard
	public void nurObjekteVonAZulassen(Node<? extends A> node) {
		System.out.println("Node: " + node.getItem().toString());	
	}
	// upper bound wildcard
	public void nurObjekteVonBZulassen(Node<? extends B> node) {
		System.out.println("Node: " + node.getItem().toString());	
	}
	// lower bound wildcard
	public void nurBasisklassenVonBZulassen(Node<? super B> node) {
		System.out.println("Node: " + node.getItem().toString());	
	}
}
