package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StackedBarChartApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		@SuppressWarnings({"unchecked", "rawtypes" }) //bäh!!!!
		StackedBarChart<String, Integer> barChart = new StackedBarChart(xAxis, yAxis);
		barChart.setData(getChartData());
		
		//set gaps between categories:
		barChart.setCategoryGap(20);
		
		barChart.setTitle("Spekulation Notenentwicklung");
		
		Pane root = new Pane();
		root.getChildren().add(barChart);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("StackedBarChart");
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
