package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

public class Wetteranzeige implements IBeobachter {
	private Wetterstation w;
	private int temp;
	private int hygro;
	private int druck;

	public Wetteranzeige(Wetterstation w_) {
		w = w_;
		temp = hygro = druck = -99999;
		w.anmelden(this);
		aktualisieren();
	}

	public String toString() {
		String erg = "Wetteranzeige:\n";
		erg += "   Temperatur: " + temp;
		erg += " Luftfeuchtigkeit: " + hygro;
		erg += " Luftdruck: " + druck;
		return erg;
	}

	public void aktualisieren(){
		int aktTemp, aktHygro, aktDruck;
		boolean geaendert = false;
		
		aktTemp=w.getTemperatur();
		if (aktTemp != temp) {
			temp = aktTemp;
			geaendert = true;
		}
		
		aktHygro=w.getLuftfeuchtigkeit();
		if (aktHygro != hygro){
			hygro = aktHygro;
			geaendert = true;
		}
		
		aktDruck=w.getLuftdruck();
		if (aktDruck != druck){
			druck = aktDruck;
			geaendert = true;
		}
		if (geaendert)
			System.out.println(this);
	}
}
