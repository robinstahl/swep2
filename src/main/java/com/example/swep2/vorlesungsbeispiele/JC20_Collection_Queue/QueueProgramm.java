package com.example.swep2.vorlesungsbeispiele.JC20_Collection_Queue;

import java.util.LinkedList;
import java.util.Queue;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

public class QueueProgramm {

	public static void main(String[] args) {
		Queue<Student> studis = new LinkedList<Student>();
		
		studis.offer(new Student("Maier", "Hugo", 111111, 5, 167));
		studis.offer(new Student("Müller", "Hans", 222222, 1, 201));
		studis.offer(new Student("Schulze", "Heinz", 333333, 4, 178));
		studis.offer(new Student("Schmid", "Heike", 444444, 2, 175));
		
		System.out.println(studis.poll());
		
		System.out.println("---------------------------------");
		studis.offer(new Student("Meier", "Hanna", 555555, 2, 181));

		Student s;
		while ((s = studis.poll()) != null) {
			System.out.println(s);
		}
	}
}
