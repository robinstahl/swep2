package com.example.swep2.vorlesungsbeispiele.JC19_Collection_Comparator;

import java.util.Comparator;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

public class VglStudentGroesse implements Comparator<Student> {
	public int compare(Student s1, Student s2){
		return s1.getGroesse() - s2.getGroesse(); 
	}
}
