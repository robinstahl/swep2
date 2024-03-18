package com.example.swep2.vorlesungsbeispiele.JC24_AusgabeUeberLabel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// setzt den Text in der Fenstertitelleiste
		primaryStage.setTitle("Hello World");
		
		// Wir wollen nun ein einfaches Label im Fenster darstellen.
		// Die GUI-Komponente Label enthaelt einen kurzen Text und stellt ihn
		// dar.
		Label label = new Label("Gruesse an alle, die auf dem Planet Erde leben!");
		
		// das hier braucht man nicht, ist nur dazu da, die Schriftgröße anzuheben
		//label.setStyle("-fx-font: 14 arial;");
		label.setFont(new Font("Arial", 20f));
		
		// Eine Scene wird benötigt, um den Szenegraph aufzubauen
		// Sie nimmt den Root Node auf
		Scene myScene = new Scene(label);
		
		// der Stage muss man mitteilen, welche Szene angezeigt werden soll
		primaryStage.setScene(myScene);
		
		// der Stage sollte man sagen, dass sie die benötigte Größe annehmen soll
		primaryStage.sizeToScene();

		// zeigt die stage an
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
