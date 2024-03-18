package com.example.swep2.vorlesungsbeispiele.JC35_LokaleKlasse;

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
	
	public void meineMethode() {
		//public, private, protected sind hier nicht erlaubt!
		class InnereKlasse{
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
			
			private void ausgeben(){
				System.out.println("Aus äußerer Klasse: aeussereZahl = " + aeussereZahl);
				System.out.println("Aus innerer Klasse: innereZahl = " + innereZahl);
				aeussereZahl ++;
				System.out.println("Aus äußerer Klasse: aeussereZahl = " + aeussereZahl);
			}		
		}
		
		// Hier geht die Methode meineMethode erst richtig los...
		System.out.println("In meineMethode\n---");
		InnereKlasse inner1 = new InnereKlasse(3);
		inner1.ausgeben();
		System.out.println("---");
		InnereKlasse inner2 = new InnereKlasse(4);
		inner2.innereZahl++;
		inner2.ausgeben();
		System.out.print("Ende meineMethode");
	}
}
