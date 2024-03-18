package com.example.swep2.vorlesungsbeispiele.JC50_MVC_EinfuehrungController;

import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<IObserver> observer;
	
	public Subject() {
		observer = new ArrayList<IObserver>();
	}
	
	public void anmelden (IObserver b){
		observer.add(b);
	}
	
	public void abmelden (IObserver b){
		observer.remove(b);
	}
	
	public void benachrichtigen(){
		for (IObserver obsrv : observer){
			obsrv.aktualisieren();
		}
	}
}