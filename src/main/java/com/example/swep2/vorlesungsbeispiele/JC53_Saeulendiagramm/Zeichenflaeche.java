package com.example.swep2.vorlesungsbeispiele.JC53_Saeulendiagramm;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Zeichenflaeche extends Canvas {
	private double bar_a, bar_b, bar_c;
	private double border = 15.0;

	public Zeichenflaeche() {
		this(400.0, 400.0);
	}

	public Zeichenflaeche(double width, double height) {
		super(width, height);
	}

	public void draw() {
		Platform.runLater(() -> {
			GraphicsContext g = this.getGraphicsContext2D();

			// aktuelle Breite und Höhe ermitteln:
			double winWidth = this.getWidth();
			double winHeight = this.getHeight();

			// alles erst mal löschen:
			g.clearRect(0, 0, winWidth, winHeight);

			// zeichne Null-Linie:
			g.strokeLine(border, winHeight - border, winWidth - border, winHeight - border);

			// zeichne drei 100er-Linien, d.h. ganz oben ist 300
			double vertLineDistance = ((winHeight - 2 * border) / 3.0);
			g.strokeLine(border, winHeight - border - vertLineDistance, winWidth - border,
					winHeight - border - vertLineDistance);
			g.strokeLine(border, border + vertLineDistance, winWidth - border, border + vertLineDistance);
			g.strokeLine(border, border, winWidth - border, border);

			// berechne Balkenbreite und -höhe
			double barWidth = winWidth / 5;
			double barHeight_a = bar_a * (winHeight - 2 * border) / 300.0;
			double barHeight_b = bar_b * (winHeight - 2 * border) / 300.0;
			double barHeight_c = bar_c * (winHeight - 2 * border) / 300.0;

			// zeichne Balken a
			g.setFill(Color.BLUE);
			g.fillRect(2 * border, winHeight - (border + barHeight_a), barWidth, barHeight_a);
			g.setFill(Color.WHITE);
			g.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.ITALIC, 20));
			g.fillText(String.valueOf((int)bar_a), 2 * border + 2, winHeight - (border + barHeight_a) + 20);

			// zeichne Balken b
			g.setFill(Color.YELLOW);
			double start_x = (winWidth - barWidth) / 2;
			g.fillRect(start_x, winHeight - (border + barHeight_b), barWidth, barHeight_b);

			// zeichne Balken c
			g.setFill(Color.RED);
			g.fillRect(winWidth - 2 * border - barWidth, winHeight - (border + barHeight_c), barWidth, barHeight_c);
		});

	}

	public void drawBars(double a, double b, double c) {
		bar_a = a;
		bar_b = b;
		bar_c = c;
		draw();
	}
}
