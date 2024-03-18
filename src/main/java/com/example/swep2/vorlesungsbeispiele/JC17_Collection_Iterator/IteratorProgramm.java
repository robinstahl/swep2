package com.example.swep2.vorlesungsbeispiele.JC17_Collection_Iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorProgramm {

	public static void main(String[] args) {
		LinkedList<String> liste = new LinkedList<String>();
		
		liste.add("Ralf");
		liste.add("Rick");
		liste.add("Rolf");
		liste.add("Rob");
		liste.add("Raoul");
		
		Iterator<String> it = liste.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		
		System.out.println("Jetzt die Schleife:");
		while (it.hasNext()){
			System.out.println(it.next());
		}
		// oder ohne explizit den Iterator zu verwenden
		System.out.println("Jetzt die verkürzt notierte Schleife:");
	    for (String s : liste)
	    	System.out.println(s);
	}
}
