package com.example.swep2.vorlesungsbeispiele.JC02_AbstrakteKlasse;


public abstract class Hochschulangehoeriger {
	private String name;
	private String vorname;
	
	public Hochschulangehoeriger() {
		System.out.println("im Konstruktor der abstrakten Klasse");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public abstract int gibSchluessel();
	
	@Override
	public String toString(){
		return name + " " + vorname + " " + gibSchluessel();
	}
}
