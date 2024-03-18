package com.example.swep2.vorlesungsbeispiele.JC54_PhysicalAnimation;


import java.io.File;
import java.net.URL;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ball {

	protected double[] geschwindigkeit;
	protected double[] position;
	protected double bodenHoehe = 0;

	private final double gravity = 9.8; // Gravitationskraft
	private Image geladenesBild;

	public Ball() {
		geschwindigkeit = new double[2];
		geschwindigkeit[0] = 0.0f;
		geschwindigkeit[1] = 0.0f;
		position = new double[2];
		position[0] = 0;
		position[1] = 0;
		geladenesBild = ladeBild("Fussball.png");
	}

	// nimmt die aktuellePosition des Balls und berechnet anhand der
	// Hoehe des Ballbildes die Position des Bodens
	public void setzeBodenHoehe() {
		bodenHoehe = position[1] + geladenesBild.getHeight() - 7;
	}

	public double gibBodenHoehe() {
		return bodenHoehe;
	}

	public void setzePos(double x, double y) {
		position[0] = x;
		position[1] = y;
	}

	public void setzeGeschw(double dx, double dy) {
		geschwindigkeit[0] = dx;
		geschwindigkeit[1] = dy;
	}

	public double getPosX() {
		return position[0];
	}

	public double getPosY() {
		return position[1];
	}

	public void zeichne(GraphicsContext g) {
		g.drawImage(geladenesBild, position[0], position[1]);
	}

	public boolean bewege(double zeitDiff) {

		geschwindigkeit[1] += gravity * zeitDiff; // = beschleunigung * zeit

		// abnehmende Geschwindigkeit simulieren
		geschwindigkeit[0] = 0.998 * geschwindigkeit[0];
		geschwindigkeit[1] = 0.985 * geschwindigkeit[1];
		//System.out.println(geschwindigkeit[0] + ", " + geschwindigkeit[1]);
		// setze neue Ballkoordinaten
		position[0] += zeitDiff * geschwindigkeit[0];
		position[1] += zeitDiff * geschwindigkeit[1];

		double h = geladenesBild.getHeight();

		// Ball am Boden dotzen lassen
		if (position[1] + 0.75 * h > bodenHoehe) {
			geschwindigkeit[1] = -geschwindigkeit[1];
			position[1] += zeitDiff * geschwindigkeit[1];
			if (geschwindigkeit[1] > -1 || geschwindigkeit[0] < 0.75) //Bewegung stoppen
				return false;
		}
		return true;
	}

	public boolean angeklicked(double x, double y) {

		boolean retVal = true;
		double w = geladenesBild.getWidth();
		double h = geladenesBild.getHeight();
		if (x < position[0] || x > position[0] + w || y < position[1] || y > position[1] + h)
			retVal = false;

		return retVal;
	}

	protected Image ladeBild(String dateiname) {
		Image bild = null;
		try {
			URL bildURL = getClass().getResource("/resources/" + dateiname);
			//URL bildURL = new URL("file:/C:/tmp/" + dateiname);

			File file = new File(bildURL.getFile());
			if (file.exists())
				bild =  new Image(getClass().getResourceAsStream("/resources/" + dateiname));
			else
				System.out.println(bildURL.toString() + " existiert nicht!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bild;
	}
}
