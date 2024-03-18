package com.example.swep2.vorlesungsbeispiele.JC02_AbstrakteKlasse;


public class Student extends Hochschulangehoeriger {
	private int matrikelNr;
	
	public Student(String name, String vorname, int matrikelNr){
		setName(name);
		setVorname(vorname);
		setMatrikelNr(matrikelNr);
	}
	
	public int getMatrikelNr() {
		return matrikelNr;
	}

	public void setMatrikelNr(int matrikelNr) {
		this.matrikelNr = matrikelNr;
	}

	@Override
	public int gibSchluessel(){
		return matrikelNr;
	}

	@Override
	public String toString() {
		return "***" + super.toString();
	}
}
