package com.example.swep2.vorlesungsbeispiele.JC34_Innereklasse;

import com.example.swep2.vorlesungsbeispiele.JC34_Innereklasse.AeussereKlasse.InnereKlasse;

public class AeussereKlasseProgramm {

	static InnereKlasse init(AeussereKlasse a) {
		
		InnereKlasse b = a.new InnereKlasse(2);
		return b;
	}
	
	public static void main(String[] args) {
		
		AeussereKlasse a = new AeussereKlasse(8);
		a.meineMethode();
	
		// Der folgende Code zeigt, wie die Erzeugung einer Instanz
		// der inneren Klasse unter Zuhilfenahme einer Instanz 
		// der äußeren Klasse funktioniert.
		// Voraussetzung: InnereKlasse darf nicht "private" sein, sonst
		// ist sie hier nicht sichtbar!
		InnereKlasse c = init(a);				// Variante 1
	//	InnereKlasse d = a.new InnereKlasse(4); // Variante 2
		// Voraussetzung für den folgenden Code: ausgeben ist nicht "private"
		c.ausgeben();
	//	d.ausgeben();
		// so funktioniert es nicht:
		//InnereKlasse ik = new InnereKlasse(10);
		// Error: "No enclosing instance of type AeussereKlasse is accessible..."
	}
}
