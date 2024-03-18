package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<IBeobachter> beobachter;
	
	public Subject() {
		beobachter = new ArrayList<IBeobachter>();
	}
	
	public void anmelden (IBeobachter b){
		beobachter.add(b);
	}
	
	public void abmelden (IBeobachter b){
		beobachter.remove(b);
	}
	
	public void benachrichtigen(){
		for (IBeobachter beob : beobachter){
			beob.aktualisieren();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private ArrayList<IBeobachter> beobachter;
//	
//	public Subject(){
//		beobachter = new ArrayList<IBeobachter>();
//	}
//	
//	public void anmelden(IBeobachter b){
//		beobachter.add(b);
//	}
//	
//	public void abmelden(IBeobachter b){
//		int i = beobachter.indexOf(b);
//		if (i >= 0){
//			beobachter.remove(i);
//		}
//	}
//	
//	public void benachrichtigen(){
//		for (IBeobachter b: beobachter){
//			b.aktualisieren();
//		}		
//	}
//}
