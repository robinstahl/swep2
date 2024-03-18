package com.example.swep2.vorlesungsbeispiele.JC05_Generics_Motivation;

// Eigentlich ist der Sourcecode zwischen PunktDouble und PunktInteger 
// identisch. Lediglich der Datentyp der Koordinaten ist im einen Fall 
// integer und im anderen Fall double. Durch Generics wird es moeglich
// nur eine Klasse zu schreiben und den Datentyp ueber den formalen 
// Typ-Parameter unspezifiziert zu lassen. Erst bei Nutzung der Klasse
// durch Erzeugung eines Objektes wird dann der formale Typ-Parameter 
// durch einen konkreten Datentypen ersetzt.
public class PunktDouble {
	private double x;
	private double y;
	
	public PunktDouble(){
		setX(0);
		setY(0);
	}
	
	public PunktDouble(double a, double b){
		setX(a);
		setY(b);
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
