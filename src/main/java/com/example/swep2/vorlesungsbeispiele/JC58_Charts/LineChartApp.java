package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LineChartApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		@SuppressWarnings({"unchecked", "rawtypes" }) //bäh!!!!
		LineChart<String, Integer> lineChart = new LineChart(xAxis, yAxis);
		lineChart.setData(getChartData());
		lineChart.setTitle("Spekulation Notenentwicklung");
		
		//use different fills for alternating rows
		//lineChart.setAlternativeRowFillVisible(true);
		
		Pane root = new Pane();
		root.getChildren().add(lineChart);
		Scene scene = new Scene(root);
		
		//scene.getStylesheets().add("style.css");//in order to make alternativeRowFill visible
		//style.css must reside in a source folder called resources and contain the following lines:
		//.chart-alternative-row-fill {
		//    -fx-fill: #BBBBBB; /* or any other color */
		//}

		primaryStage.setScene(scene);
		primaryStage.setTitle("LineChart");
		primaryStage.show();
	}

	private ObservableList<Series<String, Integer>> getChartData() {
		int einser = 14;
		int zweier = 15;
		int dreier = 20;
		int vierer = 25;
		int fuenfer = 40;
		ObservableList<Series<String, Integer>> data = FXCollections.observableArrayList();
		Series<String, Integer> sEinser = new Series<>();
		Series<String, Integer> sZweier = new Series<>();
		Series<String, Integer> sDreier = new Series<>();
		Series<String, Integer> sVierer = new Series<>();
		Series<String, Integer> sFuenfer = new Series<>();
		sEinser.setName("Einser");
		sZweier.setName("Zweier");
		sDreier.setName("Dreier");
		sVierer.setName("Vierer");
		sFuenfer.setName("Fuenfer");
		for (int i = 2020; i <= 2025; i++) {
			sEinser.getData().add(new XYChart.Data<String, Integer>(""+i, einser));
			sZweier.getData().add(new XYChart.Data<String, Integer>(""+i, zweier));
			sDreier.getData().add(new XYChart.Data<String, Integer>(""+i, dreier));
			sVierer.getData().add(new XYChart.Data<String, Integer>(""+i, vierer));
			sFuenfer.getData().add(new XYChart.Data<String, Integer>(""+i, fuenfer));
			//randomly change values for next year
			einser += 5 * Math.random() - 2;
			zweier += 5 * Math.random() - 2;
			dreier += 5 * Math.random() - 2;
			vierer += 5 * Math.random() - 2;
			fuenfer += 5 * Math.random() - 2;
		}
		data.add(sEinser);
		data.add(sZweier);
		data.add(sDreier);
		data.add(sVierer);
		data.add(sFuenfer);
		return data;
	}
}
