package com.example.swep2.vorlesungsbeispiele.JC22_Collection_HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.example.swep2.vorlesungsbeispiele.JC18_Collection_Stack.Student;

import java.util.Set;

public class HashMapProgramm {

	public static void main(String[] args) {
		HashMap<Integer,Student> studMap = new HashMap<Integer,Student>();
		HashSet<Student> studSet = new HashSet<Student>();

		Student s = new Student("Maier", "Hugo", 123456, 5, 167);
		studMap.put(s.hashCode(), s);
		studSet.add(s);

		s = new Student("M�ller", "Heinz", 234567, 2, 183);
		studMap.put(s.hashCode(), s);
		studSet.add(s);
		
		Set<Integer> ali = studMap.keySet();
		for (int i : ali) System.out.println(i);
		
		for (Student st : studSet)
			System.out.println(st);
		
		for (Entry<Integer, Student> entry : studMap.entrySet())
			System.out.println(entry);
		
	}

}
