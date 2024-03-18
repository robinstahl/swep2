package com.example.swep2.vorlesungsbeispiele.JC44_Dialog;

import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UnserFenster extends Application {
	Button b1, b2, b3, b4, b5, b6, b7;
	
	public UnserFenster(){
	}
	
	public class MeinB1Listener implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Wollen Sie wirklich alles löschen?");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent()) { // bei CONFIRMATION kommt man nur mit isPresent==true raus...
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
			Alert alert = new Alert(AlertType.ERROR,"Datei konnte nicht gefunden werden!");
			alert.showAndWait();
			System.out.println("jetzt geht es ohne Datei weiter...");
		}
	}

	public class MeinB3Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION, "Flugbuchung erfolgreich abgeschlossen.");
			alert.showAndWait();
		}
	}
	
	public class MeinB4Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.WARNING, "Der Prüfungstermin ist in naher Zukunft!");
			alert.showAndWait();
		}
	}
	
	private class MeinB5Listener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.NONE, "Irgendeine Info", ButtonType.OK);
			alert.setHeaderText("Meine Nachricht"); //oberer Bereich
			alert.setTitle("Mein Dialog"); //Fenstertitel
			alert.showAndWait();
		}
		
	}
	
	/**
	 * class to show how easy you can use the alert window
	 * for creating own dialogs
	 * 
	 * @author Prof. Dr. Erich Müller
	 *
	 */
	private class MeinBXListener implements EventHandler<ActionEvent> {
		private int value = 0;
		private Label myText = new Label("");
		private Label myText1 = new Label("Hallo");
		private Label myText2 = new Label("Welt");
		private VBox vbox = new VBox();
		private Alert alert;
		
		public MeinBXListener() {
			alert = new Alert(AlertType.NONE);
			alert.getButtonTypes().addAll(ButtonType.NEXT, ButtonType.PREVIOUS, ButtonType.CANCEL);
			DialogPane dp = alert.getDialogPane();
			vbox.getChildren().addAll(myText1, myText, myText2);
			dp.setContent(vbox);
		}

		@Override
		public void handle(ActionEvent event) {
			myText.setText("" + value);
			Optional<ButtonType> bt = alert.showAndWait();
			if(bt.isPresent())
				if (bt.get()==ButtonType.NEXT)
					value++;
				else if (bt.get() == ButtonType.PREVIOUS)
					value--;
				else if (bt.get() == ButtonType.CANCEL)
					System.out.println(value);
		}
		
	}
	
	private class MeinB6Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Sendungsnummer");
			tid.setHeaderText("Sendungsnummer eingeben:");
			Optional<String> result = tid.showAndWait();
			if (result.isPresent())
				System.out.println(result.get());
		}
		
	}
	
	/**
	 * 
	 * MyCol is a class just for demonstrating how classes can be used in Dialogs
	 * as return types for Optional<T>
	 * you need a toString()-method for displaying text in choice-box
	 * @author Prof. Dr. Erich Mueller
	 *
	 */
	private class MyCol {
		private String s;
		public MyCol(String s) { this.s = s;}
		public String toString() {return s;}
	}
	
	private class MeinB7Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			MyCol deflt = new MyCol("rot");
			List<MyCol> choices = List.of(new MyCol("gelb"), new MyCol("gruen"), deflt, new MyCol("blau"));
			ChoiceDialog<MyCol> cd = new ChoiceDialog<MyCol>(deflt, choices);
			cd.setTitle("Farbe");
			cd.setHeaderText("Wählen Sie eine Farbe:");

			//anderen Style wählen:
			//cd.getDialogPane().getStyleClass().removeAll("choice-pane");
			//cd.getDialogPane().getStyleClass().addAll("alert", "information");
			
			Optional<MyCol> result =  cd.showAndWait();
			if (result.isPresent())
				System.out.println(result.get());
			else
				System.out.println("abgebrochen...");
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		
		b1 = new Button("Bestätige");
		b1.setMaxWidth(Double.MAX_VALUE);
		b1.setOnAction(new MeinB1Listener());
		
		b2 = new Button("Fehler!");
		b2.setMaxWidth(Double.MAX_VALUE);
		b2.setOnAction(new MeinB2Listener()); 
		
		b3 = new Button("Information");
		b3.setMaxWidth(Double.MAX_VALUE);
		b3.setOnAction(new MeinB3Listener());

		b4 = new Button("Warnung!");
		b4.setMaxWidth(Double.MAX_VALUE);
		b4.setOnAction(new MeinB4Listener());

		b5 = new Button("None...");
		b5.setMaxWidth(Double.MAX_VALUE);
		b5.setOnAction(new MeinBXListener());//alternativ: MeinBXListener
		
		b6 = new Button("Text Input");
		b6.setMaxWidth(Double.MAX_VALUE);
		b6.setOnAction(new MeinB6Listener());

		b7 = new Button("ChoiceDialog");
		b7.setMaxWidth(Double.MAX_VALUE);
		b7.setOnAction(new MeinB7Listener());

		root.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7);

		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
}
