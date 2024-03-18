package com.example.swep2.vorlesungsbeispiele.JC29_Enumeration;

import javafx.scene.paint.Color;

public enum RGBFarbe {
    
	ROT(255,0,0), GRUEN(0,255,0), BLAU(0,0,255), 
	CYAN(0,255,255), MAGENTA(255,0,255), GELB(255,255,0);
	
	final int r, g, b;
	
	private RGBFarbe(int r, int g, int b) {
    	    this.r = r;
    	    this.g = g;
    	    this.b = b;
    }
	
	/**
	 * 
	 * @return the number of enumeration objects in RGBFarbe
	 */
	public static int anzFarben() { return 6; }
	
	public static RGBFarbe get(int idx) {
		
		switch(idx) {
		case 0:
			return RGBFarbe.ROT;
		case 1:
			return RGBFarbe.GRUEN;
		case 2:
			return RGBFarbe.BLAU;
		case 3:
			return RGBFarbe.CYAN;
		case 4: 
			return RGBFarbe.MAGENTA;
		case 5:	
	        return RGBFarbe.GELB;
		}
		return null;
	}
	
	/**
	 * 
	 * @param alpha defines opaqueness. 1.0 means fully opaque.
	 * @return the corresponding color according to the rgb-attributes of the enumeration object
	 */
	public Color toColor(double alpha) {
	    return Color.rgb(r,g,b, alpha);	
	}
	
	@Override
	public String toString() {
		switch (this) {
		case ROT:
			return "Rot";
		case GRUEN:
			return "Grün";
		case BLAU:
			return "Blau";
		case CYAN:
			return "Cyan";
		case MAGENTA:
			return "Magenta";
		case GELB:
			return "Gelb";
		}
		return "";
	}
	
}
