package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import javafx.application.Platform;

public class Model {

	private int[] data;
	private View view;
	
	public Model() {
		data = new int[20];
		for (int i = 0; i < 20; i++) {
			data[i] = (int)(Math.random() * 101);
		}
	}
	
	public void anmelden(View v) {
		view = v;
	}
	
	public void createValue() {
		System.out.println("createValue in " + Thread.currentThread());
		for (int i = 1; i < 20; i++) {
			data[i-1] = data[i];
		}
		data[19] = (int)(Math.random() * 101);
		view.update();
	}
	
	public int[] getData() {
		return data;
	}
}
