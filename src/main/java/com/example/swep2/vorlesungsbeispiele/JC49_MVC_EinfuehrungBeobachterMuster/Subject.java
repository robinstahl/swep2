package com.example.swep2.vorlesungsbeispiele.JC49_MVC_EinfuehrungBeobachterMuster;

import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<IObserver> beobachter;
	
	public Subject() {
		beobachter = new ArrayList<IObserver>();
	}
	
	public void anmelden (IObserver b){
		beobachter.add(b);
	}
	
	public void abmelden (IObserver b){
		beobachter.remove(b);
	}
	
	public void benachrichtigen(){
		for (IObserver beob : beobachter){
			beob.aktualisieren();
		}
	}
}