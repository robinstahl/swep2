package com.example.swep2.vorlesungsbeispiele.JC14_Collection_Lotto;

import java.util.Arrays;

public class Berechnungen {
	public int neueZufallszahl49(){
		return (int)(Math.random()*49+1);
	}
	
	public void zehnMalLotto(){
		int[] lottozahlen = new int[6];
		
		for (int i = 1; i <= 10; i++){
			lottozahlen[0] = neueZufallszahl49();
			lottozahlen[1] = neueZufallszahl49();
			lottozahlen[2] = neueZufallszahl49();
			lottozahlen[3] = neueZufallszahl49();
			lottozahlen[4] = neueZufallszahl49();
			lottozahlen[5] = neueZufallszahl49();
			
			Arrays.sort(lottozahlen);
			for (int zahl : lottozahlen){
				System.out.printf("%2d ", zahl);
			}
			System.out.println();
		}
	}
}
