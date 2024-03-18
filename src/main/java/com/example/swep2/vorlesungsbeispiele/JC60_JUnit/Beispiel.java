package com.example.swep2.vorlesungsbeispiele.JC60_JUnit;

public class Beispiel {

	private int value;
	
	public Beispiel() {
		System.out.println(super.toString());
	}
	
	public int add(int x, int y) {
		return x+y;
	}
	
	public void setValue(int x) {
		this.value = x;
	}
	
	public int getValue() {
		return value;
	}
	
	public double divide(int z, int n) {
		if (n==0) throw new ArithmeticException("Division durch Null!!");
		return z/n;
	}
	
	public static void main(String[] args) {
		Beispiel obj = new Beispiel();
		int summe = obj.add(12, 13);
		System.out.println(summe);
		System.out.println(obj.divide(5,0));
	}

}
