package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Dr. Erich Müller
 * Zu diesem Beispiel gehören auch die Klassen Model und View
 * Hier wird mit einem abgespeckten Observer-Pattern versucht,
 * Änderungen einer Datenbasis visuell darzustellen. Für alle
 * Swing-Programmierer: es gibt kein repaint()!
 */
public class CanvasExample3 extends Application {
	Model m;
	View v;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 *
	 */
	@Override
	public void start(Stage stage) throws Exception {
		m = new Model();
		v = new View(m);
		Canvas c = v.getCanvas();
		Pane root = new Pane(c);
		stage.setScene(new Scene(root));
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 1000, 2000);

		stage.show();
		stage.setOnCloseRequest(e -> {
			timer.cancel();
		});
//		stage.addEventHandler(Event.ANY, e-> {
//			System.out.println("Event Name: " + e);
//			System.out.println("Event Source: " + e.getSource());
//			System.out.println("Event Target: " + e.getTarget());
//		});
	}

	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("timer-thread: " + Thread.currentThread());
			m.createValue();
		}
	}

}
