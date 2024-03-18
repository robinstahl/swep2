package com.example.swep2.vorlesungsbeispiele.JC56_ObjectTransitions;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ObjectTransitions extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Rechteck für die Transitionen
		final Rectangle rect = new Rectangle(40,40,40,40);
		rect.setFill(Color.GREENYELLOW);
		rect.setEffect(new Lighting());

		Button fadeButton = new Button("fade");
		Button fillButton = new Button("fill");
		Button scaleButton = new Button("scale");
		Button rotateButton = new Button("rotate");
		
		fadeButton.setMaxWidth(Double.MAX_VALUE);
		fillButton.setMaxWidth(Double.MAX_VALUE);
		scaleButton.setMaxWidth(Double.MAX_VALUE);
		rotateButton.setMaxWidth(Double.MAX_VALUE);

		FadeTransition fadeTrans = new FadeTransition(Duration.millis(2000), rect);
		FillTransition fillTrans = new FillTransition(Duration.millis(1000), rect);
		ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(2000), rect);
		RotateTransition rotateTrans = new RotateTransition(Duration.millis(2000), rect);

		fadeTrans.setCycleCount(6);
		fadeTrans.setAutoReverse(true);
		fadeTrans.setFromValue(1.0);
		fadeTrans.setToValue(0.2);

		fillTrans.setCycleCount(5);
		fillTrans.setAutoReverse(true);
		fillTrans.setFromValue(Color.GREENYELLOW);
		fillTrans.setToValue(Color.DARKRED);

		scaleTrans.setCycleCount(6);
		scaleTrans.setAutoReverse(true);
		scaleTrans.setFromX(1.0);
		scaleTrans.setToX(2.0);
		scaleTrans.setFromY(1.0);
		scaleTrans.setToY(2.0);
		
		rotateTrans.setCycleCount(3);
		rotateTrans.setInterpolator(Interpolator.LINEAR);
		rotateTrans.setAutoReverse(false);
		rotateTrans.setByAngle(360);

		fadeButton.setOnAction(e -> fadeTrans.play());
		fillButton.setOnAction(e -> fillTrans.play());
		scaleButton.setOnAction(e -> scaleTrans.play());
		rotateButton.setOnAction(e -> rotateTrans.play());

		final VBox buttonPanel = new VBox();
		buttonPanel.getChildren().addAll(fadeButton, fillButton, scaleButton, rotateButton);

		final Pane pane = new Pane();
		pane.setPadding(new Insets(70));
		pane.getChildren().add(rect);

		final BorderPane root = new BorderPane();
		root.setLeft(buttonPanel);
		root.setCenter(pane);

		primaryStage.setScene(new Scene(root, 380, 200));
		primaryStage.setTitle(this.getClass().getSimpleName());
		primaryStage.show();
	}

}
