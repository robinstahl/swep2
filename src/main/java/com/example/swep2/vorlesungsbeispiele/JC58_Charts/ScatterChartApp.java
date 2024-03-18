package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScatterChartApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		@SuppressWarnings({"unchecked", "rawtypes" }) //bäh!!!!
		ScatterChart<Integer, Integer> scatterChart = new ScatterChart(xAxis, yAxis);
		scatterChart.setData(getChartData());
		
		//enhancements for readability - set interval on xAxis
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(2020);
		xAxis.setUpperBound(2025);
		
		//provide title of scart
		scatterChart.setTitle("Spekulation Notenentwicklung");
		
		Pane root = new Pane();
		root.getChildren().add(scatterChart);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("ScatterChart");
		primaryStage.show();
	}
	
	private ObservableList<Series<Integer, Integer>> getChartData() {
		int einser = 14;
		int zweier = 15;
		int dreier = 20;
		int vierer = 25;
		int fuenfer = 40;
		ObservableList<Series<Integer, Integer>> data = FXCollections.observableArrayList();
		Series<Integer, Integer> sEinser = new Series<>();
		Series<Integer, Integer> sZweier = new Series<>();
		Series<Integer, Integer> sDreier = new Series<>();
		Series<Integer, Integer> sVierer = new Series<>();
		Series<Integer, Integer> sFuenfer = new Series<>();
		//improvement: 		//add labels by naming the series
		sEinser.setName("Einser");
		sZweier.setName("Zweier");
		sDreier.setName("Dreier");
		sVierer.setName("Vierer");
		sFuenfer.setName("Fuenfer");
		for (int i = 2020; i <= 2025; i++) {
			sEinser.getData().add(new XYChart.Data<Integer, Integer>(i, einser));
			sZweier.getData().add(new XYChart.Data<Integer, Integer>(i, zweier));
			sDreier.getData().add(new XYChart.Data<Integer, Integer>(i, dreier));
			sVierer.getData().add(new XYChart.Data<Integer, Integer>(i, vierer));
			sFuenfer.getData().add(new XYChart.Data<Integer, Integer>(i, fuenfer));
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
