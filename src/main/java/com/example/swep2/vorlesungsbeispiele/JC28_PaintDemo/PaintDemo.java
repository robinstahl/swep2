package com.example.swep2.vorlesungsbeispiele.JC28_PaintDemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PaintDemo extends Application {

	public static void main(String[] args) {
		PaintDemo.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane fp = new FlowPane();
		fp.setPrefSize(400, 600);
		Region r;
		
		Stop [] stops = { new Stop(0, Color.RED), new Stop(0.3, Color.BLUE), new Stop(1, Color.YELLOW)};

		//Farbverlauf horizontal, proportional
//		LinearGradient gradient = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops);

		//Farbverlauf diagonal, proportional
//		LinearGradient gradient = new LinearGradient(0,0,1,1, true, CycleMethod.NO_CYCLE, stops);
		
		//Farbverlauf diagonal, nicht proportional
//		LinearGradient gradient = new LinearGradient(0, 0, 100, 100, false, CycleMethod.NO_CYCLE, stops);
		
		//Farbverlauf diagonal, nicht proportional, repeated
//		LinearGradient gradient = new LinearGradient(0, 0, 100, 100, false, CycleMethod.REPEAT, stops);
		
		//Farbverlauf diagonal, nicht proportional, reflected
//		LinearGradient gradient = new LinearGradient(0, 0, 100, 100, false, CycleMethod.REFLECT, stops);

		//Farbverlauf radial, aus Zentrum , 150x150, r=100, nicht proportional
		Circle circle = new Circle(100);
//		RadialGradient gradient = new RadialGradient(0, 0, 0, 0, 100, false, CycleMethod.REFLECT, stops);
		
		//Farbverlauf radial, 45 Grad, halbe Distanz, 150x150, r=100, nicht proportional
//		RadialGradient gradient = new RadialGradient(45, 0.5, 150, 150, 100, false, CycleMethod.REPEAT, stops);
		
		//Farbverlauf radial, -45 Grad, Fokuspunkt halbe Distanz, zentriert, r=d/2, proportional
		RadialGradient gradient = new RadialGradient(-45, 0.5, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);


		//für LinearGradient:
//		BackgroundFill bgf = new BackgroundFill(gradient, null, null);
//		Background backg = new Background(bgf);
//		fp.setBackground(backg);
		
		//für RadialGradient:
		circle.setFill(gradient);
		fp.getChildren().add(circle);
		fp.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(fp);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

}
