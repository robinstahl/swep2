package com.example.swep2.vorlesungsbeispiele.JC16_Collection_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListProgramm {

	public static void main(String[] args) {
		long start, ende;
		String test = "Test";
		ArrayList<String> arrListe = new ArrayList<String>();
		LinkedList<String> linListe = new LinkedList<String>();
		
		System.out.println("Befüllen ArrayList:");
		start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++){
			arrListe.add(0, test);
		}
		ende = System.currentTimeMillis();
		System.out.println("Benötigte Zeit: " + (ende - start));
		
		System.out.println("Befüllen LinkedList:");
		start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++){ 			
			linListe.add(0, test);
		}
		ende = System.currentTimeMillis();
		System.out.println("Benötigte Zeit: " + (ende - start));
		
		System.out.println("50000-tes Element bei ArrayList ausgeben:");
		start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++){
			test = arrListe.get(50000);
		}
		ende = System.currentTimeMillis();
		System.out.println("Benötigte Zeit: " + (ende - start));
		
		System.out.println("50000-tes Element bei LinkedList ausgeben:");
		start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++){ 
			test = linListe.get(50000);
		}
		ende = System.currentTimeMillis();
		System.out.println("Benötigte Zeit: " + (ende - start));

	}

}
