package com.example.swep2.vorlesungsbeispiele.JC13_Comparable;

import java.util.*;

public class ComparableProgramm {

	public static void main(String[] args) {
		Integer[] a = new Integer[4];
		a[0] = 12; //new Integer(12); deprec.
		a[1] = 10; //new Integer(10);
		a[2] = 20; //new Integer(20);
		a[3] = 5;  //new Integer(5);
		
		System.out.println("Array a:");
		for (Integer i : a) System.out.println(i);
		
		Arrays.sort(a);
		
		System.out.println("Nach Sortierung:");
		for (Integer i : a) System.out.println(i);
				
		Student[] s = new Student[4];
		s[0] = new Student("Müller", "Hugo", 765432);
		s[1] = new Student("Maier", "Hans", 234567);
		s[2] = new Student("Schulze", "Hilde", 123456);
		s[3] = new Student("Mair", "Heike", 435261);
		
		System.out.println("Array s:");
		for (Student i : s) System.out.println(i);
		
		Arrays.sort(s);
		
		System.out.println("Nach Sortierung:");
		for (Student i : s) System.out.println(i);

	}
}
