package com.example.swep2.vorlesungsbeispiele.JC25_Uebergabeparameter;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloUebergabeparameter extends Application {

	private String greetPersons;

	@Override
	public void init() {
		String params = getParameters().getRaw().toString();
		System.out.println(params); //zur Erläuterung der Delimiter
		StringTokenizer st = new StringTokenizer(params, " ,[]", false);
		
		greetPersons = "Hallo ";
		if (!st.hasMoreTokens()) {
			greetPersons = "Fehler: Vorname(n) als Argumente erwartet";
		} else {
			greetPersons += st.nextToken();
			if (st.hasMoreTokens()) {
				while (st.countTokens() > 1) {
					greetPersons += ", " + st.nextToken();
				}
				greetPersons += " und " + st.nextToken();
			}
		}

		// mit Generics:
		//
		Parameters parameters = getParameters();
		Map<String, String> namedParameters = parameters.getNamed();
		List<String> rawArguments = parameters.getRaw();
		List<String> unnamedParameters = parameters.getUnnamed();

		System.out.println("\nnamedParameters -");
		for (Map.Entry<String, String> entry : namedParameters.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());

		System.out.println("\nrawArguments -");
		for (String raw : rawArguments)
			System.out.println(raw);

		System.out.println("\nunnamedParameters -");
		for (String unnamed : unnamedParameters)
			System.out.println(unnamed);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World v2");

		Label label = new Label(greetPersons);

		// das hier braucht man nicht, ist nur dazu da, die Schriftgröße anzuheben
		label.setStyle("-fx-font: 18 arial;");

		Scene myScene = new Scene(label);
		primaryStage.setScene(myScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
