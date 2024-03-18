package com.example.swep2.vorlesungsbeispiele.JC02_AbstrakteKlasse;


public class Professor extends Hochschulangehoeriger {
	private int personalNr;
	
	public Professor(String name, String vorname, int personalNr) {
		setName(name);
		setVorname(vorname);
		setPersonalNr(personalNr);
	}

	public int getPersonalNr() {
		return personalNr;
	}

	public void setPersonalNr(int personalNr) {
		this.personalNr = personalNr;
	}

	@Override
	public int gibSchluessel(){
		return personalNr;
	}
}
