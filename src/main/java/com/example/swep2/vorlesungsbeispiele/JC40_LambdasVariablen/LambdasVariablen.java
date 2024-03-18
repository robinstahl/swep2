package com.example.swep2.vorlesungsbeispiele.JC40_LambdasVariablen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LambdasVariablen extends Application {
	private String s = "Mein Text";

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("klick me");
		button.setOnAction(e -> {
			String s = "auch Text";
			System.out.println("this.s = " + this.s);
			System.out.println("s = " + s);
		});
		button.addEventHandler( ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			private String s = "naja, hier ist Text!";
			@Override
			public void handle(ActionEvent event) {
				System.out.println("this.s = " + this.s);
				System.out.println("lv.this.s = " + LambdasVariablen.this.s);
			}
			
		});
		
		primaryStage.setScene(new Scene(button));
		primaryStage.show();
		
	}

}
