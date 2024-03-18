package com.example.swep2.vorlesungsbeispiele.JC55_Metronome;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MetronomeTransition extends Application {

	Button startButton;
	Button pauseButton;
	Button resumeButton;
	Button stopButton;
	Circle circle;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		circle = new Circle(100, 50, 4, Color.BLUE);
		TranslateTransition animation = new TranslateTransition(new Duration(1000.0), circle);
		animation.setFromX(0);
		animation.setToX(200);
		animation.setAutoReverse(true);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.setInterpolator(Interpolator.LINEAR);
		startButton = new Button("start");
		startButton.setOnAction(e -> animation.playFromStart());
		pauseButton = new Button("pause");
		pauseButton.setOnAction(e -> animation.pause());
		resumeButton = new Button("resume");
		resumeButton.setOnAction(e -> animation.play());
		stopButton = new Button("stop");
		stopButton.setOnAction(e -> animation.stop());
		
		HBox commands = new HBox(10, startButton, pauseButton, resumeButton, stopButton);
		commands.setLayoutX(80);
		commands.setLayoutY(420);
		
		Group group = new Group(circle, commands);
		Scene scene = new Scene(group, 400, 500);
		
		startButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.STOPPED));
		pauseButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
		resumeButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.PAUSED));
		stopButton.disableProperty().bind(animation.statusProperty().isEqualTo(Animation.Status.STOPPED));
		
		stage.setScene(scene);
		stage.setTitle("Metronome");
		stage.show();
		
	}

}
