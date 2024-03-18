package com.example.swep2.vorlesungsbeispiele.JC37_ButtonBeobachter;

import javafx.application.Application;
import javafx.stage.Stage;

public class JC19Programm extends Application {

	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		ButtonSceneCreator bf = new ButtonSceneCreator();
		stage.setTitle(bf.getTitle());
		stage.setScene(bf.getScene());
		stage.show();
		
	}
}
