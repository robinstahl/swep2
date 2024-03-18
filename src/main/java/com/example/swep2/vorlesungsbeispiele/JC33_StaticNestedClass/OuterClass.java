package com.example.swep2.vorlesungsbeispiele.JC33_StaticNestedClass;

public class OuterClass {
	private int x;
	private YetAnotherInnerClass yaic = new YetAnotherInnerClass(29);
	
	public OuterClass(int wert){
		x = wert;
	}
	
	public void meineMethode(int wert){
		//Zugriff auf InnerClass wie bei jeder anderen Top-Level-Klasse
		InnerClass ic = new InnerClass(x+wert);
		System.out.println(ic.y);//Zugriff auf alle Elemente der inneren Klasse!
		System.out.println(ic.toString());
	}
	public String toString(){
		return "x="+x+"\n"+yaic.toString();
	}
	
	
	public static class InnerClass{
		// diese Klasse hat keinen Zugriff auf x von OuterClass,
		// da dies ein Instanzattribut (kein Klassenattribut) ist!
		private int y;
		private YetAnotherInnerClass yaic = new YetAnotherInnerClass(31);
		public InnerClass(int wert){
			y = wert;
		}
		public String toString(){
			return "y="+y+"\n"+yaic.toString();
		}
	}
	
	private static class YetAnotherInnerClass{
		private int z;
		public YetAnotherInnerClass(int wert){
			z=wert;
		}
		public String toString(){
			return "z="+z;
		}
	}

}
