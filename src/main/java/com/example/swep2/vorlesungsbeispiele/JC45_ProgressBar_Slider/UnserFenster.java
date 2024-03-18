package com.example.swep2.vorlesungsbeispiele.JC45_ProgressBar_Slider;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class UnserFenster extends Application {
	ProgressBar progBar;
	ProgressIndicator progIndi;
	Button startButton, loeschenButton;
	Label red, green, blue;
	Slider sRed, sGreen, sBlue;
	TextField tRed, tGreen, tBlue;
	TilePane progBarPanel;
	GridPane sliderPanel;
	BorderPane root;
	Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new BorderPane();
		root.setPadding(new Insets(10));
		scene = new Scene(root);
		
		root.setBackground(new Background(new BackgroundFill(Color.rgb(222, 222, 200),CornerRadii.EMPTY, Insets.EMPTY)));
		
		// Knoepfe mit JProgressBar:
		startButton = new Button("Start");
		startButton.setOnAction(new StartButtonListener());
		startButton.setMaxWidth(Double.MAX_VALUE);
		loeschenButton = new Button("Löschen");
		loeschenButton.setOnAction(new LoeschenListener());
		loeschenButton.setMaxWidth(Double.MAX_VALUE);
		progBar = new ProgressBar(0.0);
		progIndi = new ProgressIndicator(0.0);
		progIndi.progressProperty().bind(progBar.progressProperty());
	  
		progBarPanel = new TilePane();
		progBarPanel.setPrefColumns(4);
		progBarPanel.getChildren().addAll(startButton, loeschenButton, progBar, progIndi);
		progBarPanel.setPadding(new Insets(10));
		progBarPanel.setHgap(5);
		root.setTop(progBarPanel);

		//Beschreibung:
		red = new Label("Rot: ");
		green = new Label("Grün: ");
		blue = new Label("Blau: ");
		
		//Slider mit Farbänderung
		sRed = new Slider(0, 255, 222);
		sRed.valueProperty().addListener(new MeinSliderListener());
		sRed.setOnMouseClicked(e -> {
			if (e.getClickCount() == 2)
				sRed.setValue(255);
		});
		sRed.setMajorTickUnit(100);
		sRed.setMinorTickCount(2);
		sRed.setShowTickLabels(true);
		sRed.setShowTickMarks(true);

		sGreen = new Slider(0, 255, 222);
		sGreen.valueProperty().addListener(new MeinSliderListener());
		sGreen.setOnMouseClicked(new MeinSliderMouseListener());

		sBlue = new Slider(0, 255, 200);
		sBlue.valueProperty().addListener(new MeinSliderListener());
		sBlue.setOnMouseClicked(new MeinSliderMouseListener());
	
		
		tRed = new TextField();
		tRed.setEditable(false);
		tGreen = new TextField();
		tGreen.setEditable(false);
		tBlue = new TextField();
		tBlue.setEditable(false);
		
		tRed.setText("222");
		tGreen.setText("222");
		tBlue.setText("200");
		
		sliderPanel = new GridPane();
		
		sliderPanel.addRow(0, red, sRed, tRed);
		sliderPanel.addRow(1, green, sGreen, tGreen);
		sliderPanel.addRow(2, blue, sBlue, tBlue);
		
		root.setCenter(sliderPanel);
		
		primaryStage.setTitle("Progressbar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public class StartButtonListener implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			//über einen extra Thread gehe ich, weil ich die
			//Methode sleep aufrufen möchte, aber den Thread,
			//in dem die GUI läuft, nicht schlafen lassen möchte.

			//Setze Knopf hellgrau
			startButton.setDisable(true);
			loeschenButton.setDisable(true);

			//Setze Cursor auf "Sanduhr"
			scene.setCursor(javafx.scene.Cursor.WAIT);

			MeinTask t = new MeinTask();
			progBar.progressProperty().unbind();
			progBar.progressProperty().bind(t.progressProperty());
			t.setOnSucceeded(e -> { //wenn Task erfolgreich beendet, dann...
				//Setze Cursor auf Pfeil
				scene.setCursor(javafx.scene.Cursor.DEFAULT);
				
				//Setze Knopf normal
				startButton.setDisable(false);
				loeschenButton.setDisable(false);
				
			});
			new Thread(t).start();
			

		}
	}
	
	public class LoeschenListener implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			progBar.progressProperty().unbind();
			progBar.setProgress(0);
		}
	}
	
	public class MeinTask extends Task<Void>{
		@Override
		protected Void call() throws Exception {
			for (int i = 0; i <= 100; i+=10) {
				this.updateProgress(i, 100);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					//do nothing
				}
			}
			return null;
		}
	}
	
	//Listener für die drei Slider:
	public class MeinSliderListener implements ChangeListener<Number>{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			Integer ir = (int) sRed.getValue();
			Integer ig = (int) sGreen.getValue();
			Integer ib = (int) sBlue.getValue();
			BackgroundFill bgf = new BackgroundFill(Color.rgb(ir,ig,ib), CornerRadii.EMPTY, Insets.EMPTY);
			root.setBackground(new Background(bgf));
			tRed.setText(ir.toString());
			tGreen.setText(ig.toString());
			tBlue.setText(ib.toString());
		}
	}
	
	public class MeinSliderMouseListener implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent event) {
			if (event.getClickCount() == 2) {
				((Slider) event.getSource()).setValue(255);
			}
		}
	}
}
