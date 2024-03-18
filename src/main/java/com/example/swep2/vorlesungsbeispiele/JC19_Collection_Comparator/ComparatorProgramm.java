package com.example.swep2.vorlesungsbeispiele.JC19_Collection_Comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

public class ComparatorProgramm {

	public static void main(String[] args) {
		// Erstelle Liste mit Studenten und sortiere
		// diese einmal nach Matrikelnummer und einmal
		// nach Groesse.
		
		LinkedList<Student> studenten = new LinkedList<Student>();
		
		// Befuellen der Liste:
		studenten.add(new Student("Maier", "Hugo", 123456, 5, 167));
		studenten.add(new Student("Müller", "Hans", 654321, 1, 201));
		studenten.add(new Student("Schulze", "Heinz", 321456, 4, 177));
		studenten.add(new Student("Schmid", "Heike", 111111, 2, 195));
		studenten.add(new Student("Meier", "Hanna", 999999, 2, 184));
		
		// Ausgeben as is:
		System.out.println("Ausgabe, wie eingegeben:");
		for (Student x : studenten) System.out.println(x);
		
		// Ausgeben sortiert nach MatrikelNr
		System.out.println("Ausgabe, sortiert nach Matrikelnummer:");
		Collections.sort(studenten, new VglStudentMatrikelNr());
		for (Student x : studenten) System.out.println(x);		
		
		// Ausgeben sortiert nach Groesse:
		System.out.println("Ausgabe, sortiert nach Groesse:");
		Collections.sort(studenten, new VglStudentGroesse());
		for (Student x : studenten) System.out.println(x);
		
		// Ausgeben sortiert nach Semester
		System.out.println("Ausgabe, sortiert nach Semester:");
		Collections.sort(studenten, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getSemester()-o2.getSemester();
			}
			
		});
		for (Student x : studenten) System.out.println(x);
		
		// Hier Unterschied darstellen zu:
		//Collections.sort(studenten); // hierzu muesste noch Comparable realisiert werden!
	}
}
