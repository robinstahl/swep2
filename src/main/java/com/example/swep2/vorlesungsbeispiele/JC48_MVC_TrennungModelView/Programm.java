package com.example.swep2.vorlesungsbeispiele.JC48_MVC_TrennungModelView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Programm extends Application {

	MultiplizierModel model;
	MultiplizierView view;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new MultiplizierModel();
		view = new MultiplizierView(model);
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multiply Big Integers 2");
		primaryStage.show();
	}
}
