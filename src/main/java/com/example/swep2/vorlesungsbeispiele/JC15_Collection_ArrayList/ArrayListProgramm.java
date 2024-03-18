package com.example.swep2.vorlesungsbeispiele.JC15_Collection_ArrayList;

import java.util.ArrayList;

public class ArrayListProgramm {

	public static void main(String[] args) {
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("Hugo");
		liste.add("Hans");
		liste.add("Heinz");
		liste.add("Henry");
		liste.add("Hanno");
		
		System.out.println(liste);
		
		liste.add(4, "Hermann");
		System.out.println(liste);
		
		liste.addAll(liste);
		System.out.println(liste);
		
		liste.remove(2);
		//liste.remove("Hanno");
		//alle Vorkommen von Hanno entfernen:
		ArrayList<String> hannolist = new ArrayList<String>();
		hannolist.add("Hanno");
		liste.removeAll(hannolist);
		System.out.println(liste);
		
	}
}
