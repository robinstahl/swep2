package com.example.swep2.vorlesungsbeispiele.JC51_Shapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShapeDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 // Kreisbogen mit Beleuchtung
		  final Arc arc = new Arc(0,20, 50, 50, 135, 270);
		  arc.setType(ArcType.ROUND);
		  arc.setFill(Color.GREENYELLOW);
		  arc.setEffect(new Lighting());
		  
		  // Kreis mit Reflexion und Beleuchtung
		  final Circle circle = new Circle(10, 30, 30, Color.FIREBRICK);
		  Reflection refl = new Reflection();
		  Lighting ligh = new Lighting();
		  refl.setInput(ligh);
		  circle.setEffect(refl);

		  // Linie mit Schatten
		  final Line line = new Line(0, 0, 40, 10);
		  line.setEffect(new DropShadow());

		  // Rechteck mit Beleuchtung und Schatten
		  Rectangle rectangle = new Rectangle(10, 10, 120, 120);
		  rectangle.setArcWidth(20);
		  rectangle.setArcHeight(20);
		  rectangle.setFill(Color.DODGERBLUE);
		  //customized Schatten:
		  DropShadow shadow = new DropShadow();
		  shadow.setWidth(20);
		  shadow.setHeight(20);
		  shadow.setOffsetX(10);
		  shadow.setOffsetY(10);
		  shadow.setRadius(20);
		  //perspektivische Verformung:
		  PerspectiveTransform trans = new PerspectiveTransform();
		  trans.setLlx(0);   //lower left corner
		  trans.setLly(120);
		  trans.setUlx(40);  // upper left corner
		  trans.setUly(60);
		  trans.setUrx(150); // upper right corner
		  trans.setUry(60);
		  trans.setLrx(120); // lower right corner
		  trans.setLry(120);
		  //Kombination aus Licht, Transformation und Schatten:
		  Lighting ligh2 = new Lighting();
		  trans.setInput(ligh);
		  shadow.setInput(trans);
		  rectangle.setEffect(shadow);
		  
		  //Text mit Effekten:
		  Light.Distant light = new Light.Distant();
		  light.setAzimuth(-135.0);

		  Lighting lighting = new Lighting();
		  lighting.setLight(light);
		  lighting.setSurfaceScale(5.0);

		  Text text = new Text();
		  text.setText("JavaFX!");
		  text.setFill(Color.STEELBLUE);
		  text.setFont(Font.font(null, FontWeight.BOLD, 60));

		  text.setEffect(lighting);
		  
		  Slider slider = new Slider(1.0, 10.0, 5.0);
		  lighting.surfaceScaleProperty().bind(slider.valueProperty());
		  
		  final FlowPane flowPane = new FlowPane();
		  flowPane.setPadding(new Insets(10));
		  flowPane.getChildren().addAll(arc, circle, line, rectangle, text, slider);
		  primaryStage.setScene(new Scene(flowPane, 380, 200));
		  primaryStage.setTitle(this.getClass().getSimpleName());
		  primaryStage.show();
	}

}
