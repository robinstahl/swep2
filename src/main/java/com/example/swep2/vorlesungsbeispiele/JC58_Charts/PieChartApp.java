package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PieChartApp extends javafx.application.Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		PieChart chart = new PieChart();
		chart.setData(getData());
		chart.setLegendVisible(true); //standard
		chart.setLabelsVisible(true); //standard: true
		chart.setTitle("Notenverteilung");
		AnchorPane root = new AnchorPane();
		root.getChildren().add(chart);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chart Demo");
		primaryStage.show();
	}
	
	private ObservableList<PieChart.Data> getData(){
		ObservableList<PieChart.Data> data = 
				FXCollections.observableArrayList();
		data.add(new PieChart.Data("Einser", 13));
		data.add(new PieChart.Data("Zweier", 15));
		data.add(new PieChart.Data("Dreier", 20));
		data.add(new PieChart.Data("Vierer", 12));
		data.add(new PieChart.Data("Fünfer", 40));
		return data;
	}

}
