package com.example.swep2.vorlesungsbeispiele.JC49_MVC_EinfuehrungBeobachterMuster;

import java.math.BigInteger;

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

public class MultiplizierView extends HBox implements IObserver {

	// GUI Komponenten
	private Label inputL = new Label("Input");
	private Label totalL = new Label("Total");
	private TextField inputTF = new TextField();
	private TextField totalTF = new TextField();
	private Button multB = new Button("Multiply");
	private Button clearB = new Button("Clear");
	
	
	private MultiplizierModel model;
	
	public MultiplizierView(MultiplizierModel model){
		this.model = model;
		
		// Fensteraufbau:
		HBox root = this;
		this.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setMaxWidth(Double.MAX_VALUE);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		//AENDERUNG: Setzen des Textfeldes entfällt!
		//Nach der Anmeldung wird aktualisieren() gerufen, was den Startwert eintraegt
		//totalTF.setText("1");
		totalTF.setPrefColumnCount(40);
		totalTF.setEditable(false);
		
		inputTF.setPrefColumnCount(5);

		// Melde Listener für die beiden Buttons an
		multB.setOnAction(new MultiplyEventHandler());
		clearB.setOnAction(new ClearEventHandler());
		
		root.getChildren().addAll(inputL, inputTF, multB, totalL, clearB, totalTF);
		
		// AENDERUNG: View am Model anmelden	
		model.anmelden(this);
		
		// AENDERUNG: aktualisieren aufrufen, damit der "Startwert" in das Textfeld geschrieben wird
		aktualisieren();
	}
	
	public void anzeigen(String str) {
	    totalTF.setText(str);
	}
	
	// Die beiden EventHandler-Klassen, die das Verhalten bei Knopfdruck
	// implementieren
	
	class MultiplyEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e){
			try{
				// Der Konstruktor von BigInteger wirft eine NumberFormatException,
				// wenn der übergebene String-Parameter kein gültiges 
				// BigInteger-Format hat.
				
				model.multipliziere(new BigInteger(inputTF.getText()));
				
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
			model.reset();
		}
	}
	
	@Override
	public void aktualisieren() {
		anzeigen(model.getAktuellerWert().toString());
		
	}
}


