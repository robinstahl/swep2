package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExample1 extends Application {
	private double x, y, dx, dy;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Canvas canvas = new Canvas(500, 300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		canvas.setOnMousePressed(e -> {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			x = e.getX();
			y = e.getY();
		});
		canvas.setOnMouseDragged(e -> {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			dx = e.getX() - x;
			dy = e.getY() - y;
//			gc.fillRect(x, y, dx, dy);
			gc.fillRect(dx < 0 ? x + dx : x, dy < 0 ? y + dy : y, dx < 0 ? -dx : dx, dy < 0 ? -dy : dy);
		});
		stage.setScene(new Scene(new Group(canvas)));
		stage.setTitle("Boxen zeichnen");
		stage.show();
	}

}
