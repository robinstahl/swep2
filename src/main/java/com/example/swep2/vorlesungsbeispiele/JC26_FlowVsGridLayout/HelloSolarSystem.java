package com.example.swep2.vorlesungsbeispiele.JC26_FlowVsGridLayout;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

// Wenn wir eine geeignete Platzierung mehrerer GUI-Komponenten in einem Fenster beabsichtigen,
// dann muessen wir uns die Frage stellen, wie wir diese Komponenten in dem Fenster
// darstellen bzw. arrangieren moechten. Die einfachste Methode ein bestimmtes 
// Layout zu erreichen, ist ein Layout Pane zu benutzen. Hierfuer gibt dieser
// Code ein Beispiel, wie man Layout Panes verwendet und welche Auswirkungen sie haben:

public class HelloSolarSystem extends Application {
	private final String font = "-fx-font: 18 arial;";
	private Label larr[] = new Label[9];

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hallo Sonnensystem");
		larr[0] = new Label("Hallo Merkur!");
		larr[1] = new Label("Hallo Venus!");
		larr[2] = new Label("Hallo Erde!");
		larr[3] = new Label("Hallo Mars!");
		larr[4] = new Label("Hallo Jupiter!");
		larr[5] = new Label("Hallo Saturn!");
		larr[6] = new Label("Hallo Uranus!");
		larr[7] = new Label("Hallo Neptun!");
		larr[8] = new Label("Auf Wiedersehen Pluto!");
		for (Label l : larr)
			l.setStyle(font);
		
		FlowPane pane = new FlowPane(Orientation.HORIZONTAL);//oder ohne Param
		pane.setPrefWrapLength(520);
//		FlowPane pane = new FlowPane(Orientation.VERTICAL);
//		larr[6].setStyle("-fx-font: 36 arial");
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setColumnHalignment(HPos.RIGHT);
		pane.setRowValignment(VPos.CENTER); //BOTTOM, CENTER, TOP
		pane.getChildren().add(larr[0]);
		pane.getChildren().add(larr[1]);
		pane.getChildren().add(larr[2]);
		pane.getChildren().addAll(larr[3], larr[4], larr[5], larr[6], larr[7], larr[8]);

		// GridPane mit automatischen Spaltenbreiten
//		GridPane pane = new GridPane();
//		pane.setHgap(50);
//		pane.setVgap(10);
//		pane.setPadding(new Insets(15,20,25,30));
//		pane.addRow(0, larr[0], larr[1], larr[2]);
//		pane.addRow(1, larr[3], larr[4], larr[5]);
//		pane.addRow(2, larr[6], larr[7], larr[8]);
//		pane.setGridLinesVisible(true);
		
		// GridPane mit pixeldefinierten Spaltenbreiten
//		GridPane pane = new GridPane();
//		pane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
//	    pane.getColumnConstraints().add(new ColumnConstraints(200)); // column 1 is 200 wide
//	    pane.getColumnConstraints().add(new ColumnConstraints(300)); // column 2 is 300 wide
//		pane.addRow(0, larr[0], larr[1], larr[2]);
//		pane.addRow(1, larr[3], larr[4], larr[5]);
//		pane.addRow(2, larr[6], larr[7], larr[8]);
//		pane.setGridLinesVisible(true);
		
		// GridPane mit prozentual definierten Spaltenbreiten
//		GridPane pane = new GridPane();
//		ColumnConstraints column0 = new ColumnConstraints();
//	    column0.setPercentWidth(30);
//	    ColumnConstraints column1 = new ColumnConstraints();
//	    column1.setPercentWidth(20);
//	    ColumnConstraints column2 = new ColumnConstraints();
//	    column2.setPercentWidth(50);
//	    pane.getColumnConstraints().addAll(column0, column1, column2);
//		pane.addRow(0, larr[0], larr[1], larr[2]);
//		pane.addRow(1, larr[3], larr[4], larr[5]);
//		pane.addRow(2, larr[6], larr[7], larr[8]);
//		pane.setGridLinesVisible(true);
	    
	    
		
//		TilePane pane = new TilePane(Orientation.HORIZONTAL);
//		pane.setPrefColumns(2);
//		pane.setPrefRows(3);
//		pane.getChildren().addAll(larr);
		
		//Die Windows-Implementierung ist fehlerhaft...
		//Bei der Windows(!)-Einstellung Schriftgröße = 125% passt die Berechnung nicht.
		//Setzt man snapToPixel auf false, geht's manchmal, sieht aber nicht so schön aus.
//		pane.snapToPixelProperty().setValue(false);
		// oder man klickt 2x in das Fenster rein:
		//pane.setOnMouseClicked((v) -> {primaryStage.sizeToScene();});

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene(); //hier optional
		primaryStage.show();
		
/* nur für Demo-Zwecke: 
		//nachträgliche Änderung der Scene:
		Label lx = new Label ("change");
		lx.setStyle(font);
		pane.getChildren().add(lx);
		primaryStage.sizeToScene(); // sonst sieht man das neue Element nicht
*/
	}		
		
	public static void main(String[] args) {
	    //System.setProperty("prism.lcdtext", "false"); //prevent ugly font subpixel anti-aliasing
		launch(args);
	}

}
