package com.example.swep2.vorlesungsbeispiele.JC34_Innereklasse;


public class AeussereKlasse {
	private int aeussereZahl;

	public AeussereKlasse(int z){
		setAeussereZahl(z);
	}
	public int getAeussereZahl() {
		return aeussereZahl;
	}

	public void setAeussereZahl(int zahl) {
		this.aeussereZahl = zahl;
	}
	
	public void meineMethode(){
		InnereKlasse inner = new InnereKlasse(5);
		// folgender Auruf wuerde auch funktionieren, wenn die Methode ausgeben
		// private definiert sein wuerde - dann könnte man aber die Methode nicht von
		// außerhalb (z.B. main) aufrufen!
		inner.ausgeben(); 
		// Zugriff auch auf das private Attribut innereZahl! 
		System.out.println(inner.innereZahl);
		
	}
	
	// Wird die Sichtbarkeit der inneren Klasse auf public/protected festgesetzt, dann kann
	// diese auch von Aussen erzeugt werden. Die erzeugten Objekte der inneren Klasse 
	// koennen aber nur innerhalb eines Objektes der äusseren Klasse existieren.
	public class InnereKlasse { 
		 
 		private int innereZahl;

		public InnereKlasse(int z){
			setInnereZahl(z);
		}
		public int getInnereZahl() {
			return innereZahl;
		}

		public void setInnereZahl(int meineZahl) {
			this.innereZahl = meineZahl;
		}
		
		protected void ausgeben(){
			System.out.println("In InnereKlasse: aeussereZahl = " + aeussereZahl);
			System.out.println("In InnereKlasse: innereZahl = " + innereZahl);
		}
	}
}
