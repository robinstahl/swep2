package com.example.swep2.vorlesungsbeispiele.JC33_StaticNestedClass;

// mit folgendem Import kann man in Zeile 23 direkt auf 
// InnerClass zugreifen, also ohne "OuterClass."
//import JC16_StaticNestedClass.OuterClass.InnerClass;

public class StaticNestedClassProgramm {
	
	private static int outer_static_int=10;

	public static void main(String[] args) {
		System.out.println("statischer int-Wert: "+ outer_static_int);
		
		Nested nested = new Nested(12); //oder: StaticNestedClassProgramm.Nested = ...
		System.out.println("\nNested:\n" + nested.toString());	
		System.out.println("Zugriff auf nested.x von außen: " + nested.x);
		
		OuterClass outer = new OuterClass(15);
		System.out.println("\nOuterClass:");
		outer.meineMethode(1);
		System.out.println(outer.toString());
System.out.println("-----");
		OuterClass.InnerClass inner = new OuterClass.InnerClass(100);
		System.out.println("\nInnerClass (only):");
		System.out.println(inner.toString());
	
	}
	
	public static class Nested{
		private int x;
		public Nested(int wert){
			x=wert;
		}
		public String toString(){
			return "Nested_x="+x+"\n statischer int-Wert: "+outer_static_int;
		}
	}

}
