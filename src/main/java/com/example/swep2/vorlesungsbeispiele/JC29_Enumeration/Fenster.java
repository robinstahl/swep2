package com.example.swep2.vorlesungsbeispiele.JC29_Enumeration;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Fenster extends Application {
	
    public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Meine RGBFarbe als Enumeration");
		TilePane pane = new TilePane();
		pane.setPrefColumns(3);
		
		for (int i=0; i< RGBFarbe.anzFarben(); i++) {
			RGBFarbe f = RGBFarbe.get(i);
			Label label = new Label(f.toString());
			label.setBackground(new Background(new BackgroundFill(f.toColor(1.0), null, null)));
			label.setStyle("-fx-font: 24 sanserif;");
			label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			label.setAlignment(Pos.CENTER);
		    pane.getChildren().add(label);
		}
		
		Scene colorscene = new Scene(pane);
		stage.setScene(colorscene);
		stage.show();
	}
}
