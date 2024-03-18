/*
Anmerkungen:

   In dieser Klasse sind alle Funktionalit�ten der Anwendung enthalten, aber
   
    - es werden Aufgaben zur Anzeige und zur eigentlichen Berechnung vermischt
    - eine Umstellung auf eine andere GUI oder Konsolenanwendung ist nicht ohne 
      weiteres m�glich, da keine Trennung zwischen Anzeige und eigentlicher Berechnung
      erfolgte
    - eine �nderung der Benutzerschnittstelle w�rde auch den Code zur Berechnung ber�hren

   Wir wollen unseren Code immer gut wartbar gestalten. Jemand, der das Layout der Ansicht VIEW
   �ndert, sollte nur in einer Klasse etwas �ndern m�ssen. Die Berechnungen k�nnen vor ihm 
   in einer anderen Klasse MODEL versteckt werden (Information Hiding). 
   
   + Alle Daten werden nur in einer Klasse gehalten, n�mlich im MODEL. Hier k�nnen dann in einem
   Softwareprojekt Entwickler einsteigen, die eine Schnittstelle zur Datenbank anpassen m�chten,
   oder z.B. hier die Datentypen zur Multiplikation oder die Operationen ver�ndern und erweitern
   m�chten.
   
   
   Somit STEP2 -> Trennung in VIEW und MODEL
*/

package com.example.swep2.vorlesungsbeispiele.JC47_MVC_AllesInEinerKlasse;



import java.math.BigInteger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MultiplizierFenster extends Application {

	// GUI Komponenten
	private Label inputL = new Label("Input");
	private Label totalL = new Label("Total");
	private TextField inputTF = new TextField();
	private TextField totalTF = new TextField();
	private Button multB = new Button("Multiply");
	private Button clearB = new Button("Clear");
	
	// Zustand der Berechnung  (hier nur ein einzelner Wert)
	private BigInteger aktuellerWert;
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		aktuellerWert = new BigInteger("1");
		
		// Fensteraufbau:
		HBox root = new HBox(10);
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
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multiply Big Integers");
		primaryStage.show();
	}
	
	// Methode zum Anzeigen des aktuellen Wertes
	public void anzeigen() {
	    totalTF.setText(aktuellerWert.toString());
	}
	
	// Die beiden EventHandler-Klassen, die das Verhalten bei Knopfdruck
	// implementieren
	class MultiplyEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			try {
				// Der Konstruktor von BigInteger wirft eine NumberFormatException,
				// wenn der übergebene String-Parameter kein gültiges 
				// BigInteger-Format hat.
				BigInteger bInt = new BigInteger(inputTF.getText().toString());
				aktuellerWert = aktuellerWert.multiply(bInt);
				MultiplizierFenster.this.anzeigen();
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
	
	class ClearEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			aktuellerWert = new BigInteger("1");
			MultiplizierFenster.this.anzeigen();
		}
	}

}


