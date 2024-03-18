package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class BubbleChartApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//change: from NumberAxis to CategoryAxis for xAxis
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		@SuppressWarnings({"unchecked", "rawtypes" }) //bäh!!!!
		BubbleChart<Integer, Integer> bubbleChart = new BubbleChart(xAxis, yAxis);
		bubbleChart.setData(getChartData());
		
		//enhancements for readability/scaling - set interval on xAxis
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(20200); //scaling factor 10
		xAxis.setUpperBound(20250);
		xAxis.setTickUnit(10); //just interested in years, not in 1/10 of a year
		xAxis.setMinorTickCount(0);//don't show minor tick marks
		xAxis.setTickLabelFormatter(new StringConverter<Number>() {
			@Override
			public String toString(Number number) {
				return String.valueOf(number.intValue() / 10);
			}

			@Override
			public Number fromString(String string) {
				return Integer.valueOf(string) * 10;
			}
		});

		//provide title of scart
		bubbleChart.setTitle("Spekulation Notenentwicklung");
		
		Pane root = new Pane();
		root.getChildren().add(bubbleChart);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("BubbleChart");
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
		sEinser.setName("Einser");
		sZweier.setName("Zweier");
		sDreier.setName("Dreier");
		sVierer.setName("Vierer");
		sFuenfer.setName("Fuenfer");
		//change: step size is 10 because of scaling
		for (int i = 20200; i <= 20250; i+=10) {
			sEinser.getData().add(new XYChart.Data<Integer, Integer>(i, einser, 5 /*,radius*/));
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
