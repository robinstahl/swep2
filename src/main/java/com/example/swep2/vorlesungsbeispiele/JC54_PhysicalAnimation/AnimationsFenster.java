package com.example.swep2.vorlesungsbeispiele.JC54_PhysicalAnimation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnimationsFenster extends Application {

	private static final long serialVersionUID = 1L;

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		root.getChildren().add(new Animationsflaeche(1400,650));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
