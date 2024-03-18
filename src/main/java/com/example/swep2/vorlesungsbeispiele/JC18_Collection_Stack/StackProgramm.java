package com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack;

import java.util.Stack;

public class StackProgramm {


	public static void main(String[] args) {
		Stack<Student> studis = new Stack<Student>();
		
		studis.push(new Student("Maier", "Hugo", 111111, 5, 167));
		studis.push(new Student("Müller", "Hans", 222222, 1, 201));
		studis.push(new Student("Schulze", "Heinz", 333333, 4, 177));
		studis.push(new Student("Schmid", "Heike", 444444, 2, 195));
		
		System.out.println(studis.peek());
		
		studis.push(new Student("Meier", "Hanna", 555555, 2, 184));
		
		System.out.println("----------------------------------");
		while (!studis.empty()) {
			System.out.println(studis.pop());
		}
		
	}
}
