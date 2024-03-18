package com.example.swep2.vorlesungsbeispiele.JC55_Metronome;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MetronomeTimeline extends Application {

	DoubleProperty startXVal = new SimpleDoubleProperty(100.0);
	Button startButton;
	Button pauseButton;
	Button resumeButton;
	Button stopButton;
	Line line;
	Timeline animation;

	@Override
	public void start(Stage stage) throws Exception {
		animation = new Timeline(new KeyFrame(new Duration(0.0), new KeyValue(startXVal, 100.0)),
				new KeyFrame(new Duration(1000.0), new KeyValue(startXVal, 300.0, Interpolator.LINEAR)));
		animation.setAutoReverse(true);
		animation.setCycleCount(Animation.INDEFINITE);
		line = new Line(0, 50, 200, 400);
		line.setStrokeWidth(4);
		line.setStroke(Color.BLUE);
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
		
		Group group = new Group(line, commands);
		Scene scene = new Scene(group, 400, 500);
		
		line.startXProperty().bind(startXVal);
		
		startButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.STOPPED));
		pauseButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
		resumeButton.disableProperty().bind(animation.statusProperty().isNotEqualTo(Animation.Status.PAUSED));
		stopButton.disableProperty().bind(animation.statusProperty().isEqualTo(Animation.Status.STOPPED));
		
		stage.setScene(scene);
		stage.setTitle("Metronome");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
