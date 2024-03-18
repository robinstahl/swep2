package com.example.swep2.vorlesungsbeispiele.JC27_BorderLayout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;


public class BorderPaneDemo extends Application {

	public static void main(String[] args) {
		BorderPaneDemo.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panel = new BorderPane();
		
		panel.setPadding(new Insets(30,30,30,30));

		Label l1 = new Label("BorderPane-Property center: z.B. TextFeld, Datei-Liste, Bild,...");
		l1.setStyle("-fx-background-color: yellow;");
		l1.setPrefSize(500,300);
		// damit das Label den ganzen Platz ausfüllen darf, setzen wir die 
		// MaxSize auf MAX_VALUE
		// verwendet man Container (z.B. HBox) statt Controls, so werden diese 
		// automatisch auf die gesamte Größe "aufgezogen".
		l1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		panel.setCenter(l1);
		
		Label l2 = new Label("BorderPane-Property top: z.B. Toolbar");
		//einfache Farbe:
		BackgroundFill bgf = new BackgroundFill(Color.CORNFLOWERBLUE, null, null);
		Background backg = new Background(bgf);
		l2.setBackground(backg);
//		l2.setStyle("-fx-background-color: gray;-fx-text-fill: white;");
		l2.setPrefSize(300,50);
		l2.setMaxWidth(Double.MAX_VALUE); // oder setMaxSize(...,...);
		panel.setTop(l2);

		Label l3 = new Label("BorderPane-Property bottom: z.B. Statusleiste");
		l3.setStyle("-fx-background-color: #804040;");
		l3.setTextFill(Color.WHITE);
		l3.setPrefSize(1200, 40); //fix, ist die maximale Breite hier
		panel.setBottom(l3);
		
		Label l4 = new Label("BorderPane-Property left: z.B. Dateibaum");
		l4.setStyle("-fx-background-color: lightgray;");
		l4.setMaxHeight(Double.MAX_VALUE); // oder setMaxSize(...,...);
		panel.setLeft(l4);
		
		Label l5 = new Label("BorderPane-Property right: z.B. Toolbox");
		l5.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		panel.setRight(l5);

		Scene scene = new Scene(panel);
		stage.setScene(scene);
		stage.setTitle("Programm demonstriert die BorderPane");
		stage.show();
		
	}

}
