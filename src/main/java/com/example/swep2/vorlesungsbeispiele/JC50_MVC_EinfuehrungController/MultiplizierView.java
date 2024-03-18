/*
    STEP4 -> Einführung Controller
   
    Anmerkungen:
    
        - Jetzt haben wir eine Trennung zwischen Kontrollanweisungen
          (Umsetzung Benutzereingaben in Operationen des Models oder View),
          dem Modell und der View erreicht
          
        - Der Controller  kann auch ein Beobachter des Models  sein, 
          falls sein Verhalten vom Model-Zustand abhängen soll
          (Wird hier aber zur Vereinfachung nicht weiter betrachtet)
          
*/

package com.example.swep2.vorlesungsbeispiele.JC50_MVC_EinfuehrungController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

// Implementiert das Interface IBeobachter
public class MultiplizierView extends HBox implements IObserver {

	// GUI Komponenten
	private Label inputL = new Label("Input");
	private Label totalL = new Label("Total");
	private TextField inputTF = new TextField();
	private TextField totalTF = new TextField();
	private Button multB = new Button("Multiply");
	private Button clearB = new Button("Clear");
	
	private MultiplizierModel model;
	
	// AENDERUNG: Die View besitzt einen Controller
	private MultiplizierController controller;
	
	public MultiplizierView(MultiplizierModel model){
		
		this.model = model;
		
		// AENDERUNG: Die View erzeugt einen Controller
		controller = new MultiplizierController(model, this);
		
		// Fensteraufbau:
		HBox root = this;
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setMaxWidth(Double.MAX_VALUE);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		//AENDERUNG: Setzen des Textfeldes entfällt!
		//Nach der Anmeldung wird aktualisieren() gerufen, was den Startwert eintraegt
		//totalTF.setText("1");
		totalTF.setPrefColumnCount(40);
		totalTF.setEditable(false);
		
		inputTF.setPrefColumnCount(5);
		
		root.getChildren().addAll(inputL, inputTF, multB, totalL, clearB, totalTF);
		
		model.anmelden(this);
		aktualisieren();
		
		// AENDERUNG: Die EventHandler-Anmeldung übernimmt jetzt der Controller
		// Wir stellen jetzt nur Methoden zum Anmelden bzw. Abmelden bereit s.u.
	}
	
	// Methode zum Anzeigen des aktuellen Wertes als String-Argument
	public void anzeigen(String str) {
	    totalTF.setText(str);
	}

	// Durch das Interface IObserver wurde diese Methode eingeführt,
	// um die Anzeige zu aktualisieren, wenn sich der Wert im Modell ändert
	public void aktualisieren() {
		anzeigen(model.getAktuellerWert().toString());
	}
	
	// AENDERUNG: Für den Controller eine Anmelderoutine von EventHandler
	// an den Multiplizier-Button bereitstellen
	public void addMultEventHandler(EventHandler<ActionEvent> al){
		multB.setOnAction(al);
	}
	
	// AENDERUNG: Für den Controller eine Anmelderoutine von EventHandler
	// an den Clear-Button bereitstellen
	public void addClearEventHandler(EventHandler<ActionEvent> al){
		clearB.setOnAction(al);
	}
	
	// AENDERUNG: Für den Controller muss eine Möglichkeit zum Auslesen
	// des Textfeldes für den Multiplikator bereitgestellt werden
	public String getUserInput() {
		return inputTF.getText();
	}
	
	// AENDERUNG: Fehler treten auch ausserhalb der View-Klasse auf. Wir
	// stellen dem Model und dem Controller die Möglichkeit zur Fehleranzeige
	// in einem Dialog bereit
	public void showError(String errMsg){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(errMsg);
		alert.showAndWait();
	}
	
	/**
	 * clean up: abmelden vom model
	 */
	public void dropView() {
		model.abmelden(this);
	}
}


