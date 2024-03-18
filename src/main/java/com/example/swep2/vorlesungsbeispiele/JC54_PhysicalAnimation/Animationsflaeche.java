package com.example.swep2.vorlesungsbeispiele.JC54_PhysicalAnimation;


import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Animationsflaeche extends Canvas {
	
	private Timer t;
	private long animationLastTime;
	private Ball ball;
	private final float startGeschX =  60.0f;
	private final float startGeschY = -100.0f;
	
	public Animationsflaeche(int width, int height) {
		super(width, height);
		ball = new Ball();
		ball.setzePos(10,500);
		ball.setzeGeschw(startGeschX, startGeschY);
		ball.setzeBodenHoehe();
		
		// Starte mit der Animation sobald die Maustaste gedrueckt wurde
		this.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
				if (ball.angeklicked(e.getSceneX(), e.getSceneY())==true) starteTimer(); });
		
		// Zeichne Startsituation
		draw();
	}
	
	private void starteTimer() {
		t = new Timer();
		animationLastTime = System.currentTimeMillis();
		//t.scheduleAtFixedRate(new BallAnimation(), 0, 30);
		t.scheduleAtFixedRate(new BallAnimation(), 0, 10);
	}
	
	private void stoppeTimer() {
		ball.setzePos(10,500);
		ball.setzeBodenHoehe();
		ball.setzeGeschw(startGeschX, startGeschY);
		t.cancel();
	}

	// Zeichnen des Panels
	public void draw() {
		Platform.runLater(() -> {
			GraphicsContext g = this.getGraphicsContext2D();
			//g.clearRect(0,0,this.getWidth(), this.getHeight()); 
			g.fillRect(0, ball.gibBodenHoehe()+7, this.getWidth(), 5);
		    ball.zeichne(g);		
		});
	}
	
	public class BallAnimation extends TimerTask {
		@Override
		public void run() {
			// Zeitdifferenz berechnen
			long zeitDiff = System.currentTimeMillis() - animationLastTime;
			animationLastTime += zeitDiff;
			if (!ball.bewege(zeitDiff/100.0f))
				stoppeTimer();
				
			if (ball.getPosX() > Animationsflaeche.this.getWidth() || 
				ball.getPosY() > Animationsflaeche.this.getHeight())
				stoppeTimer();	
			//neu zeichnen
			draw();
		}
	}
}
