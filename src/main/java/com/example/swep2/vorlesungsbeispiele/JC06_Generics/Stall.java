package com.example.swep2.vorlesungsbeispiele.JC06_Generics;

public class Stall<T> {
	private T bewohner;
	
	public Stall(T bew) {
		setBewohner(bew);
	}
	
	public void setBewohner(T bew) {
		bewohner = bew;
	}
	
	public T getBewohner() {
		return bewohner;
	}
}
