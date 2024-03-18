package com.example.swep2.vorlesungsbeispiele.JC44_Dialog;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalityTester extends Application {
	public static void main(String[] args) {
		launch();
	}
	
	private Stage ownerStage; //this will be the window owning a window-modal dialog

	@Override
	public void start(Stage primaryStage) throws Exception {
		ownerStage = primaryStage;//need to save reference for external usage
		
		Stage anotherStage = new Stage();//second stage for application-modal dialog
		
		Label l1 = new Label("Hallo Fenster 1");
		Button b1 = new Button("Bestätige");
		b1.setMaxWidth(Double.MAX_VALUE);
		b1.setOnAction(new MeinB1Listener());
		VBox vbox = new VBox();
		vbox.getChildren().addAll(l1, b1);
		Scene scene1 = new Scene(vbox);
		primaryStage.setScene(scene1);
		
		Label l2 = new Label("Hallo Fenster 2");
		Button b2 = new Button("Sonstwas");
		b2.setMaxWidth(Double.MAX_VALUE);
		b2.setOnAction(new MeinB2Listener());
		VBox vbox2 = new VBox();
		vbox2.getChildren().addAll(l2,b2);
		Scene scene2 = new Scene(vbox2);
		anotherStage.setScene(scene2);
		
		primaryStage.show();
		anotherStage.show();
		
		
	}
	public class MeinB1Listener implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Wollen Sie wirklich alles löschen? Window-modal!");
			alert.initOwner(ownerStage); //important for Modality.WINDOW_MODAL, otherwise there is no hierarchy
			alert.initModality(Modality.WINDOW_MODAL);//set modality only for hierarchy, other windows are not "blocked"
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent()) {
				if (result.get() == ButtonType.OK)
					System.out.println("Ok, Sie wollen es nicht anders...");
				else if (result.get() == ButtonType.CANCEL)
					System.out.println("Aha, Sie haben es sich doch anders überlegt.");
			} 
		}
	}

	public class MeinB2Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.ERROR,"Datei konnte nicht gefunden werden! Application-modal!");
			alert.showAndWait();
			System.out.println("jetzt geht es ohne Datei weiter...");
		}
	}

}
