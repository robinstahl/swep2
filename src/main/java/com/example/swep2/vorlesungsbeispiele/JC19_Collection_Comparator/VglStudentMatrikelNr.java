package com.example.swep2.vorlesungsbeispiele.JC19_Collection_Comparator;

import java.util.Comparator;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

// Die Klasse ist lediglich Traeger der Methode compare, die
// in dieser Implementierung Studenten nach Matrikelnummer 
// sortiert.

public class VglStudentMatrikelNr implements Comparator<Student> {
	public int compare(Student s1, Student s2){
		return s1.getMatrikelNr() - s2.getMatrikelNr();
	}
}
