package com.example.swep2.vorlesungsbeispiele.JC38_EventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JC20Programm extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		Pane pane = new Pane();
		
		Rectangle rect = new Rectangle(150,20);
		rect.setFill(Color.DARKRED);
		
		Circle circ = new Circle(60,30,30);
		circ.setFill(Color.CHARTREUSE);
		
		Ellipse elli = new Ellipse(100,30,30,20);
		elli.setFill(Color.DARKGREEN);
		
		Button butt = new Button("Hallo");
		
		pane.getChildren().addAll(circ, elli, butt);
//		circ.toFront();
		root.getChildren().addAll(rect,pane);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EH");

		//registration of Filters and Handlers
		MyEventFilter mef = new MyEventFilter();
		MyEventHandler meh = new MyEventHandler();
		MyActionEventFilter maef = new MyActionEventFilter();
		MyActionEventHandler maeh = new MyActionEventHandler();
		
		stage.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		stage.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		stage.addEventFilter(ActionEvent.ACTION, maef);
		stage.addEventHandler(ActionEvent.ACTION, maeh);
		
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		scene.addEventFilter(ActionEvent.ACTION, maef);
		scene.addEventHandler(ActionEvent.ACTION, maeh);

		root.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		root.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		root.addEventFilter(ActionEvent.ACTION, maef);
		root.addEventHandler(ActionEvent.ACTION, maeh);

		rect.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		rect.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		rect.addEventFilter(ActionEvent.ACTION, maef);
		rect.addEventHandler(ActionEvent.ACTION, maeh);

		pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		pane.addEventFilter(ActionEvent.ACTION, maef);
		pane.addEventHandler(ActionEvent.ACTION, maeh);

		circ.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		circ.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		circ.addEventFilter(ActionEvent.ACTION, maef);
		circ.addEventHandler(ActionEvent.ACTION, maeh);

		elli.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		elli.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		elli.addEventFilter(ActionEvent.ACTION, maef);
		elli.addEventHandler(ActionEvent.ACTION, maeh);

		/* Achtung: siehe https://docs.oracle.com/javafx/2/events/processing.htm
		 * Note that the default handlers for the JavaFX UI controls typically consume most of the input events.
		 * Mouse-Events sind Input-Events - beim Click auf den Button wird der MOUSE_CLICKED-Event vom Button konsumiert!!!
		 */
		butt.addEventFilter(MouseEvent.MOUSE_CLICKED, mef);
		butt.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
		butt.addEventFilter(ActionEvent.ACTION, maef);
		butt.addEventHandler(ActionEvent.ACTION, maeh);
		
		stage.show();
	}
	
	/**
	 * einfacher EventFilter, der die Klasse ausgibt, an welcher er
	 * registriert ist
	 * @author Prof. Dr. Erich Mueller
	 */
	private class MyEventFilter implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("im Filter von " + event.getSource().getClass());
		}
	}
	
	/**
	 * einfacher EventHandler, der die Klasse ausgibt,
	 * an welcher er registriert ist
	 * @author Prof. Dr. Erich Mueller
	 */
	private class MyEventHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("im Handler von " + event.getSource().getClass() + " Target:" + event.getTarget().getClass());
		}
	}

	private class MyActionEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("im ActionHandler von " + event.getSource().getClass());
		}
	}
	
	private class MyActionEventFilter implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("im ActionFilter von " + event.getSource().getClass());
		}
	}

}
