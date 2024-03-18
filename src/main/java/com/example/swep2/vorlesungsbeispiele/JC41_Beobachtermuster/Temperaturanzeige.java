package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;


public class Temperaturanzeige implements IBeobachter {
	private Wetterstation w;
	private int temp;
	
	public Temperaturanzeige(Wetterstation w_){
		w = w_;
		temp = -99;
		w.anmelden(this);
		aktualisieren();
	}
	
	public String toString(){
		String erg = "Temperaturanzeige:\n";
		erg += "   Temperatur: " + temp;
		return erg;
	}
	
	public void aktualisieren(){
		int aktTemp = w.getTemperatur();
		if (aktTemp != temp) {
			temp = aktTemp;
			System.out.println(this);
		}
	}
}
