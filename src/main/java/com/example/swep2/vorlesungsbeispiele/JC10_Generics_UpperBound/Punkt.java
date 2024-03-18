package com.example.swep2.vorlesungsbeispiele.JC10_Generics_UpperBound;

public class Punkt<T extends Number> {
	private T x;
	private T y;
	
	public Punkt(T a, T b){
		setX(a);
		setY(b);
	}
	
	public Punkt() {
		
	}
	
	public T getX() {
		return x;
	}
	
	public void setX(T x) {
		this.x = x;
	}
	
	public T getY() {
		return y;
	}
	
	public void setY(T y) {
		this.y = y;
	}
	
	// Hier laesst man offen, welchen konkreten Datentyp der Punkt hat.
	// Die Methode abstand kann auch einen Rueckgabewert berechnen, wenn 
	// die Punkte (this und p) auf unterschiedlichen Datentypen basieren! 
	// Mit der Einschraenkung Number wissen wir, dass wir auf Methoden des
	// Datentyps Number zugreifen koennen -> also auf doubleValue()
	// public double abstand(Punkt<?> p){
	// funktioniert auch, da Klasse schon auf T extends Number eingeschraenkt ist
    public double abstand(Punkt<? extends Number> p) { 
	
		double d, xThisInDouble, yThisInDouble, xPInDouble, yPInDouble;
	
		xThisInDouble = this.getX().doubleValue();
		xPInDouble = p.getX().doubleValue();
		yThisInDouble = this.getY().doubleValue();
		yPInDouble = p.getY().doubleValue();
		
		d = Math.sqrt(Math.pow(xThisInDouble - xPInDouble, 2) + Math.pow(yThisInDouble - yPInDouble, 2));
		
		return d;
	}
	
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
