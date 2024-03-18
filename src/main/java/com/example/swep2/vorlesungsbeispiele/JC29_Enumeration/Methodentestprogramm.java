package com.example.swep2.vorlesungsbeispiele.JC29_Enumeration;

public class Methodentestprogramm {

	private enum Jahreszeit {
		FRUEHLING, SOMMER, HERBST, WINTER;
		public String toString() {
			switch (this) {
			case FRUEHLING:
				return "Frühling";
			case SOMMER:
				return "Sommer";
			case HERBST:
				return "Herbst";
			case WINTER:
				return "Winter";
			default:
				return "nix davon";
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Methoden von enum-Datentypen");
		Jahreszeit j = Jahreszeit.SOMMER;
		System.out.println("name: " + j.name());
		System.out.println("ordinal: " + j.ordinal());
		System.out.println("toString: " + j.toString());
		
		Jahreszeit[] jz = Jahreszeit.values();
		System.out.println("values: ");
		for (Jahreszeit ja : jz)
			System.out.println(ja);
		
		System.out.println("equals SOMMER: " + j.equals(Jahreszeit.SOMMER));
		System.out.println("compareTo HERBST: " + j.compareTo(Jahreszeit.HERBST));
	}

}
