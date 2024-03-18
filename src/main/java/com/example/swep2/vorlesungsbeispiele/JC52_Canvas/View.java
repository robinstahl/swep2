package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class View {
	private Model model;
	private Canvas canvas;
	private int[] data;

	public View(Model m) {
		model = m;
		canvas = new Canvas(220, 120);
		m.anmelden(this);
		update();
//		draw();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * drawing on the Canvas
	 */
	private void draw() {
		Platform.runLater(() -> {
			System.out.println("view draw: " + Thread.currentThread());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			double w = canvas.getWidth();
			double h = canvas.getHeight();
			int offset = 10;
			double x, y;

			gc.clearRect(0, 0, w, h);
			gc.setStroke(Color.RED);

			gc.beginPath(); // start new path, forget the old one
			x = offset;
			y = h - offset - data[0];
			gc.moveTo(x, y); // starting point
			for (int i = 1; i < 20; i++) {
				x += offset; // step forward on the x-axis
				y = h - offset - data[i]; // compute value for y-axis
				gc.lineTo(x, y); // add segment to path
			}
			gc.stroke(); // now path is finished, draw it
		});
	}

	public void update() {
		data = model.getData();
		draw();
	}

}
