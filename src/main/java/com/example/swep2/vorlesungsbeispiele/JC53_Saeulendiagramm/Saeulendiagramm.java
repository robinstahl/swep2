package com.example.swep2.vorlesungsbeispiele.JC53_Saeulendiagramm;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Saeulendiagramm extends Application {
	private Zeichenflaeche drawingArea;
	private Timer simulator;
	
//	public Saeulendiagramm(int bar_a, int bar_b, int bar_c){
//		Container c = this.getContentPane();
//		drawingArea = new Zeichenflaeche(400,400);
//		c.add(drawingArea);
//		//drawingArea.drawBars(bar_a, bar_b, bar_c);
//		this.setTitle("Saeulendiagramm");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.pack();
//	}
	
	public void simulate(){
		simulator = new Timer();
		simulator.schedule(new DiagramSimulator(), 0, 5000);
	}
	
	private class DiagramSimulator extends TimerTask {
		@Override
		public void run() {
			double bar_a = Math.random()*300.0+1.0;
			double bar_b = Math.random()*300.0+1.0;
			double bar_c = Math.random()*300.0+1.0;
			drawingArea.drawBars(bar_a, bar_b, bar_c);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		drawingArea = new Zeichenflaeche(400,400);
		root.getChildren().add(drawingArea);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Saeulendiagramm");
		stage.setOnCloseRequest((e) -> simulator.cancel());
		stage.show();
		simulate();
	}

}
