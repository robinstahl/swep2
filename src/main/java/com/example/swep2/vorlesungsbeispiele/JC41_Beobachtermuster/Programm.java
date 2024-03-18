package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

import javafx.application.Application;
import javafx.stage.Stage;


public class Programm extends Application {
	
	private Wetterstation w;

	// Die Klasse erstellt eine Wetterstation und diverse Beobachter, die diese
	// Station beobachten. Bei Änderungen der Werte der Station werden alle
	// Beobachter benachrichtigt. Nur die, die es etwas angeht, ändern ihren
	// Zustand und zeigen sich neu an.
	// Die GUI gehört nicht zum Beobachter-Muster, ist aber zu Demonstrationszwecken
	// des Musters hilfreich. Die Eingabe wäre sonst komplizierter ;-)
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		
		// Erstellen des Subjects
		w = new Wetterstation((byte)27, (byte)51, 1000);
	
		// Hier erstellen wir verschiedene Beobachter, die sich
		// über ihren Konstruktor bei der Wetterstation w anmelden
		Wetteranzeige a = new Wetteranzeige(w);
		Temperaturanzeige t = new Temperaturanzeige(w);
		Luftdruckanzeige d = new Luftdruckanzeige(w);
		Hygrometer h = new Hygrometer(w);

		/*	
		System.out.println("---- Jetzt trifft eine Temperaturänderung ein ----");
		
		//Folgende Zeile zum Test benötigen wir nur, wenn wir die GUI
		// nicht hätten:
		System.out.println("Änderung an Wetterstation : --------------");
		w.setTemperatur((byte)30);
		*/
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Hier erstellen wir ein Fenster (GUI) aus der Klasse WetterstationGUI:
		WetterstationGUI stage = new WetterstationGUI(w);
		stage.show();
	}
}
