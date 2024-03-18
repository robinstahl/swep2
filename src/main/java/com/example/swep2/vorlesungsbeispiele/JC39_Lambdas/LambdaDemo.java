package com.example.swep2.vorlesungsbeispiele.JC39_Lambdas;

public class LambdaDemo {

	/**
	 * Konsolen-Ausgabe einer Berechnung. 20 und 10 werden entsprechend des IBerechne-Objektes verknüpft.
	 * @param b Objekt, welches IBerechne implementiert
	 */
	public static void ausgeben(IBerechne b) {
		System.out.println(b.berechne(20, 10));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ausgeben(new IBerechne() {

			@Override
			public double berechne(double a, double b) {
				return a * b;
			}
			
		});

		//Lambda-Ausdruck:
		ausgeben((a,b) -> a + b);

	}

}
