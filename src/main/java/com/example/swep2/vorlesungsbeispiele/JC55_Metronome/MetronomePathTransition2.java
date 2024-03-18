package com.example.swep2.vorlesungsbeispiele.JC55_Metronome;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MetronomePathTransition2 extends Application {
	
	Button startButton;
	Button pauseButton;
	Button resumeButton;
	Button stopButton;
	Circle circle;
	Line line;
	
	Path path;

	public static void main(String[] args) {
		System.out.println("HILFE");
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		circle = new Circle(100, 50, 2);
		circle.setFill(Color.BLUE);
		line = new Line(0, 50, 200, 400);
		line.setStrokeWidth(4);
		line.setStroke(Color.BLUE);
		line.startXProperty().bind(Bindings.add(circle.getCenterX(), circle.translateXProperty()));
		line.startYProperty().bind(Bindings.add(circle.getCenterY(), circle.translateYProperty()));
		
		path = new Path(new MoveTo(100, 50), new ArcTo(350,350,0,300,50,false, true));
		PathTransition animation = new PathTransition(new Duration(1000.0), path, circle);
		animation.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
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
		
		Group group = new Group(circle, line , commands);
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
