package com.example.swep2.vorlesungsbeispiele.JC37_ButtonBeobachter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

// Dieses Beispiel zeigt Ihnen, wie Sie Beobachter ueber die Verwendung
// der geschachtelten Klassen definieren koennen.

public class ButtonSceneCreator {

	private Button button;
	private Scene scene;
	
	public ButtonSceneCreator() {
		AnchorPane root = new AnchorPane();
		button = new Button("Click mich!");
		root.getChildren().add(button);
		scene = new Scene(root);
		
		// Einen Beobachter ueber eine anonyme Klasse hinzufuegen
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Event aufgetreten: " + event + "Objekt der anonymen Klasse ist nun ueber den Click informiert");
				//event.consume();
			}
		});

	
		// Einen Beobachter ueber eine lokale Klasse definieren
		class Beobachter implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Objekt der Klasse Beobachter ist nun ueber den Click informiert");
			}
		}
		// Einen Beobachter aus der lokalen Klasse erzeugen und anmelden
		button.addEventHandler(ActionEvent.ACTION, new Beobachter());

		// Jetzt sind zwei Beobachter angemeldet!
		// Achtung: der zweite Beobachter wurde mit addEventHandler und nicht mit setOnAction
		//          registriert. die Convenience-Methode setOnAction funktioniert nur für den
		//          ersten (oder einzigen) Handler!
	
		// Um drei Beobachter unter der Verwendung der drei verschiedenen 
		// geschachtelten Klassen zu demonstrieren, definieren wir eine
		// Innere Klasse WeitererBeobachter (siehe unten)!
		
		// Diesen muessen wir noch anmelden, indem wir ein Objekt dazu erzeugen!
		button.addEventHandler(ActionEvent.ACTION, new WeitererBeobachter());	
		
	}
	
	// Definition einer inneren Klasse als Beobachter
	// Hier ist es praktisch, dass die innere Klasse auf die privaten 
	// Attribute der auesseren Klasse zugreifen kann.
	private class WeitererBeobachter implements EventHandler<ActionEvent> {

		private Paint urspruenglicheButtonFarbe;
		private int zaehler = 0;
		
		@Override
		public void handle(ActionEvent event) {
			if (zaehler == 0)
				urspruenglicheButtonFarbe = button.getTextFill();
			if (button.getTextFill() == urspruenglicheButtonFarbe)
				button.setTextFill(Color.rgb(255,32,32));
			else
				button.setTextFill(urspruenglicheButtonFarbe);
			zaehler++;
			if (zaehler == 6)
				button.removeEventHandler(ActionEvent.ACTION, this);
		}
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public String getTitle() {
		return "EventHandler";
	}
}
