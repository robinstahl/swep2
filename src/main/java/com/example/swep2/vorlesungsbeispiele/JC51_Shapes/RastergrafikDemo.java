package com.example.swep2.vorlesungsbeispiele.JC51_Shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RastergrafikDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Wir holen uns ein Image
		//Image img = new Image(getClass().getResourceAsStream("tea.png"));
		// man kann auch eine gewünschte Größe für das Image angeben
		Image img = new Image(getClass().getResourceAsStream("linux.jpeg"),210.5,250,true,true);
			
		// Wir setzen das Image in einen Node
		ImageView imgView = new ImageView();
		imgView.setImage(img);
		imgView.maxHeight(Double.MAX_VALUE);
		imgView.maxWidth(Double.MAX_VALUE);
		
		
		//alles zur Anzeige bringen
//		AnchorPane root = new AnchorPane();
//		root.getChildren().add(imgView);
//		imgView.fitWidthProperty().bind(root.widthProperty());
//		imgView.fitHeightProperty().bind(root.heightProperty());
		Pane root = new Pane();
		root.getChildren().add(imgView);
		imgView.fitWidthProperty().bind(root.widthProperty());
		imgView.fitHeightProperty().bind(root.heightProperty());
		Scene scene = new Scene(root, 210, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Linux");
		primaryStage.show();
	}

}
