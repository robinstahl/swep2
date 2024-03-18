package com.example.swep2.vorlesungsbeispiele.JC04_Components;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KompositumFenster extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label label = new Label("Findest du mich schön?");
		label.setStyle("-fx-font: 18 arial;");
		
		Button button1 = new Button("Ja");
		button1.setStyle("-fx-font: 18 arial;");
		Button button2 = new Button("Nein");
		button2.setStyle("-fx-font: 18 arial;");
		Button button3 = new Button("Vielleicht");
		button3.setStyle("-fx-font: 18 arial;");

		HBox hbox = new HBox();
		hbox.setSpacing(7); //horizontaler Abstand der Elemente in der Box
		hbox.getChildren().addAll(button1, button2, button3);
		
		VBox vbox = new VBox();
		vbox.setFillWidth(false);//die enthaltenen Elemente füllen nicht notwendigerweise die ganze Breite aus
		vbox.setSpacing(10); //vertikaler Abstand der Elemente in der Box
		vbox.setAlignment(Pos.CENTER); //zentrierte Darstellung der enthaltenen Elemente
		vbox.setPadding(new Insets(7)); //Rand ringsum die Box
		vbox.getChildren().addAll(label,hbox);
		
		Image icon = new Image(getClass().getResourceAsStream("dating.bmp"));
		primaryStage.getIcons().add(icon);

		Scene scene = new Scene(vbox); //new Scene(vbox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Date");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
