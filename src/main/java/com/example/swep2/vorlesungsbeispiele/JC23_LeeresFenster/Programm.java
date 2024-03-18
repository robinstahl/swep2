package com.example.swep2.vorlesungsbeispiele.JC23_LeeresFenster;

import java.time.Instant;

import javafx.application.Application;
import javafx.stage.Stage;

public class Programm extends Application {
	
	public Programm() {
		System.out.println("im Konstruktor");
	}
	
	@Override
	public void init() {
		System.out.println("im init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
	}
	
	@Override
	public void stop() {
		System.out.println("im stopp");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
