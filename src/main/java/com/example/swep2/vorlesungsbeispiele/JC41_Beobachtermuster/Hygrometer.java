package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

public class Hygrometer implements IBeobachter {
	private Wetterstation w;
	private int hygro;

	public Hygrometer(Wetterstation w_) {
		w = w_;
		hygro = -99;
		w.anmelden(this);
		aktualisieren();
	}

	public void aktualisieren(){
		int neu_hygro = w.getLuftfeuchtigkeit();
		if (neu_hygro != hygro){
			hygro = neu_hygro;
			System.out.println(this);
		}
	}

	public String toString() {
		String erg = "Hygrometer:\n";
		erg += "   Luftfeuchtigkeit: " + hygro;
		return erg;
	}

	public void aktualisieren2() {
		int aktHygro = w.getLuftfeuchtigkeit();
		if (aktHygro != hygro) {
			hygro = aktHygro;
			System.out.println(this);
		}
	}
}
