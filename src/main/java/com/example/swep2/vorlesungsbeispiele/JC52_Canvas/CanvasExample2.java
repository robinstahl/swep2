package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExample2 extends Application {

	private Canvas canvas;
	private double x, y;
	Timer timer;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		timer = new Timer();
		canvas = new Canvas(300, 300);
		timer.schedule(new MyTimerTask(), 2000, 200);
		stage.setScene(new Scene(new Pane(canvas)));
		stage.setOnCloseRequest(e -> {
			timer.cancel();
		});
		stage.show();
	}

	private class MyTimerTask extends TimerTask {
		private boolean outOfBounds = false;
		@Override
		public void run() {
			System.out.println("Thread: " + Thread.currentThread());
			Platform.runLater(() -> {
				System.out.println("doing in thread " + Thread.currentThread());

				GraphicsContext context = canvas.getGraphicsContext2D();
				context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				x += 10;
				y += 10;
				if (x < canvas.getWidth() && y < canvas.getHeight()) {
					context.setFill(Color.DARKRED);
					context.fillRect(x, y, 10, 10);
				} else {
					outOfBounds = true;
				}

			});
			
			if (outOfBounds) {
				System.out.println("Cancelling the Timer...");
				timer.cancel();
			}
				
		}
	}
}
