package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

public class Luftdruckanzeige implements IBeobachter {
	private Wetterstation w;
	private int druck;
	
	public Luftdruckanzeige(Wetterstation w_){
		w = w_;
		druck = -99999;
		w.anmelden(this);
		aktualisieren();
	}
	
	public String toString(){
		String erg = "Luftdruckanzeige:\n";
		erg += "   Luftdruck: " + druck;
		return erg;
	}
	
	public void aktualisieren(){
		int aktDruck = w.getLuftdruck();
		if (aktDruck != druck){
			druck = aktDruck;
			System.out.println(this);
		}

		//Alternative in JAVA:
		//if (druck != (druck = w.getLuftdruck()))
		//	System.out.println(this);
	}
}
