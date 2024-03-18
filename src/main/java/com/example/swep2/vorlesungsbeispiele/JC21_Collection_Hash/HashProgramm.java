package com.example.swep2.vorlesungsbeispiele.JC21_Collection_Hash;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

// Betrachte hierzu die hashCode und equals-Methode in der Klasse Student
public class HashProgramm {

	public static void main(String[] args) {
		Student s = new Student("Maier", "Hugo", 123456, 5, 167);
		
		//Gleiche Referenz:
		Student t = s;
		System.out.println(s);
		System.out.println("Hashcode von s: " + s.hashCode());
		System.out.println("Hashcode von t: " + t.hashCode());
		System.out.println(s.equals(t));
	
		//Hugo Maier heiratet. Name ändert sich in Müller:
		
		s.setName("Müller");
		System.out.println(s);
		System.out.println("Hashcode von s nach Namensänderung: " + s.hashCode());
		
		// Hugo Müller kommt ein Semester weiter:
		s.setSemester(s.getSemester()+1);
		System.out.println(s);
		System.out.println("Hashcode von s: " + s.hashCode());	
		
		// Hugo Müller bekommt eine neue Matrikelnummer: 
		s.setMatrikelNr(234567);
	    System.out.println(s);
		System.out.println("Hashcode von s: " + s.hashCode());	
		
		// neuen Studenten mit gleicher Matrikelnummer anlegen und testen, ob er den selben hashCode bekommt:
		Student s2 = new Student("Mustermann", "Hugo", 234567, 7, 183);
		System.out.println(s2);
		System.out.println("Hashcode von s2: " + s2.hashCode());	
		
	}
}
