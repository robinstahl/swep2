/*
    -> Trennung in VIEW und MODEL
   
    Anmerkungen:
    
        Hier funktioniert die Anwendung nicht, da die Trennung zwischen 
        Ansicht (View) und Modell (Model) zwar vorgenommen wurde, aber
        die Ansicht bei Daten�nderung im Model nicht aktualisiert wird
        
        L�sung: Beobachtermuster im n�chsten Schritt
*/

package com.example.swep2.vorlesungsbeispiele.JC48_MVC_TrennungModelView;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MultiplizierView extends HBox {

	// GUI Komponenten
	private Label inputL = new Label("Input");
	private Label totalL = new Label("Total");
	private TextField inputTF = new TextField();
	private TextField totalTF = new TextField();
	private Button multB = new Button("Multiply");
	private Button clearB = new Button("Clear");
	
	// AENDERUNG: Model als Attribut
	private MultiplizierModel model;
	
	// AENDERUNG: Übergabeparameter für Herstellen der Assoziation 
	// mit Model eingeführt
	public MultiplizierView(MultiplizierModel model){
		this.model = model;
		
		// Fensteraufbau:
		HBox root = this;
		this.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setMaxWidth(Double.MAX_VALUE);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		totalTF.setText("1");
		totalTF.setPrefColumnCount(40);
		totalTF.setEditable(false);
		
		inputTF.setPrefColumnCount(5);

		// Melde Listener für die beiden Buttons an
		multB.setOnAction(new MultiplyEventHandler());
		clearB.setOnAction(new ClearEventHandler());
		
		root.getChildren().addAll(inputL, inputTF, multB, totalL, clearB, totalTF);
	}
	
	// AENDERUNG:
	// Methode zum Anzeigen des aktuellen Wertes als String-Argument
	public void anzeigen(String str) {
	    totalTF.setText(str);
	}
	
	// Die beiden EventHandler-Klassen, die das Verhalten bei Knopfdruck
	// implementieren
	
	// AENDERUNG:
	// Damit das Setzen eines neuen Wertes im Model bzw. das Löschen eines
	// Wertes auch die Anzeige verändert, müssen wir im nächsten Schritt 
	// auch das Beobachtermuster implementieren
	class MultiplyEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e){
			try{
				// Der Konstruktor von BigInteger wirft eine NumberFormatException,
				// wenn der übergebene String-Parameter kein gültiges 
				// BigInteger-Format hat.
				
				// AENDERUNG: Hier wird lediglich das Model zum Wertsetzen aufgerufen
				model.multipliziere(new BigInteger(inputTF.getText()));
				
				// HIER WURDE JETZT ZWAR DER WERT GESETZT, ABER DIE VIEW ERFÄHRT KEIN UPDATE
				// -> BEOBACHTER MUSTER
				// In multipliziere() muss benachrichtigen() für alle Beobachter aufgerufen werden.
				// Die View wäre somit ein Beobachter des Models
			}
			catch(Exception ex){
				// Die Fehlermeldung der NumberFormatException soll als Fehlermeldung 
				// mit einem vorgefertigten Dialog ausgegeben werden
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		}
	}
	
	class ClearEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			// AENDERUNG: Hier wird lediglich das Model zum Zurücksetzen des Wertes aufgerufen
			model.reset();
		}
	}
}


