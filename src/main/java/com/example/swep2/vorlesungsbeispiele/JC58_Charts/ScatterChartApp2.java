package com.example.swep2.vorlesungsbeispiele.JC58_Charts;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScatterChartApp2 extends Application {
	private ScatterChart<String, Integer> scatterChart;
	private Timer t;

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" }) //bäh!!!!
	@Override
	public void start(Stage primaryStage) throws Exception {
		// change: from NumberAxis to CategoryAxis for xAxis
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		// 
		// change: ScatterChart<String, Integer>
		// ScatterChart<String, Integer> scatterChart = new ScatterChart(xAxis, yAxis);
		scatterChart = new ScatterChart(xAxis, yAxis);
		scatterChart.setData(getChartData());

		t = new Timer();
		t.schedule(new ChangeData(), 1000, 1000);

		// change: no definition of interval on xAxis

		// provide title of scart
		scatterChart.setTitle("Spekulation Notenentwicklung");

		Pane root = new Pane();
		root.getChildren().add(scatterChart);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("ScatterChart");
		primaryStage.show();
	}

	private class ChangeData extends TimerTask {
		int counter = 0;

		@Override
		public void run() {
			Platform.runLater(() -> {
				//scatterChart.setData(getChartData());
				changeData(scatterChart.getData());
			});
			if (counter++ == 10)
				t.cancel();
		}
	}

	// change: Series<String, Integer>
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
		// improvement: //add labels by naming the series
		sEinser.setName("Einser");
		sZweier.setName("Zweier");
		sDreier.setName("Dreier");
		sVierer.setName("Vierer");
		sFuenfer.setName("Fuenfer");
		for (int i = 2020; i <= 2025; i++) {
			// change: Data<String, Integer>
			sEinser.getData().add(new XYChart.Data<String, Integer>("" + i, einser));
			sZweier.getData().add(new XYChart.Data<String, Integer>("" + i, zweier));
			sDreier.getData().add(new XYChart.Data<String, Integer>("" + i, dreier));
			sVierer.getData().add(new XYChart.Data<String, Integer>("" + i, vierer));
			sFuenfer.getData().add(new XYChart.Data<String, Integer>("" + i, fuenfer));
			// randomly change values for next year
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

	private void changeData(ObservableList<Series<String, Integer>> o) {
		Series<String, Integer> s = o.get(1);
		ObservableList<XYChart.Data<String, Integer>> ol = s.getData();
		XYChart.Data<String, Integer> entry = ol.get(1);
		entry.setYValue((int)(entry.getYValue()*1.2));
	}
}
