package com.example.swep2.vorlesungsbeispiele.JC50_MVC_EinfuehrungController;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// AENDERUNG: Einführung der Klasse Controller, die alle Eingaben 
// entgegennimmt und in Kontrollanweisungen für die View und das Model 
// umwandelt z.B. wird a) bei einer Exception ein Fehlerdialog der View 
// oder b) die Methode multipliziere beim Model aufgerufen
public class MultiplizierController {

	private MultiplizierModel model;
	private MultiplizierView  view;
	
	
	public MultiplizierController( MultiplizierModel model,
			                       MultiplizierView  view ) {
		this.model = model;
		this.view = view;
		
		// AENDERUNG: Die EventHander-Anmeldung übernimmt jetzt der Controller
		view.addMultEventHandler(new MultiplyEventHandler());
		view.addClearEventHandler(new ClearEventHandler());
	}
	
	// Die beiden EventHandler-Klassen, die das Verhalten bei Knopfdruck
	// implementieren
	class MultiplyEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			try {
				// Der Konstruktor von BigInteger wirft eine NumberFormatException,
				// wenn der übergebene String-Parameter kein gültiges 
				// BigInteger-Format hat.
				
				// AENDERUNG: Die Eingabe für den Multiplikator wird jetzt durch einen
				// Methodenaufruf realisiert
				model.multipliziere(new BigInteger(view.getUserInput()));
			}
			catch(Exception ex) {
				// Die Fehlermeldung der NumberFormatException soll als Fehlermeldung 
				// mit einem vorgefertigten Dialog ausgegeben werden
				
				// AENDERUNG: Damit wir eine klare Trennung zwischen grafischer 
				// Oberfläche (Zeichnen) und Kontrollanweisungen haben, werden 
				// Fehlermeldungen über die View realisiert
				view.showError(ex.getMessage());
			}
		}
	}
	
	class ClearEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			model.reset();
		}
	}
}
