package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

public class Wetterstation extends Subject {
	private byte temperatur;
	private byte luftfeuchtigkeit;
	private int luftdruck;

	public Wetterstation(byte t, byte f, int l) {
		setTemperatur(t);
		setLuftfeuchtigkeit(f);
		setLuftdruck(l);
	}

	public byte getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(byte temperatur) {
		this.temperatur = temperatur;
		benachrichtigen();
	}	

	public byte getLuftfeuchtigkeit() {
		return luftfeuchtigkeit;
	}

	public void setLuftfeuchtigkeit(byte luftfeuchtigkeit) {
		this.luftfeuchtigkeit = luftfeuchtigkeit;
		benachrichtigen();
	}

	public int getLuftdruck() {
		return luftdruck;
	}

	public void setLuftdruck(int luftdruck) {
		this.luftdruck = luftdruck;
		benachrichtigen();
	}

	public void setAll(int t, int h, int d) {
		temperatur = (byte) t;
		luftfeuchtigkeit = (byte) h;
		luftdruck = d;
		benachrichtigen();
	}
}
