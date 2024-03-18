package com.example.swep2.vorlesungsbeispiele.JC41_Beobachtermuster;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class WetterstationGUI extends Stage {
	private Wetterstation modell;

	private Label temp, hygro, druck;
	private TextField tf_temp, tf_hygro, tf_druck;
	private Button ok;

	public WetterstationGUI(Wetterstation m) {
		modell = m;

		// Hier stellen wir das Fenster zusammen
		TilePane root = new TilePane();
		root.setPrefColumns(2);

		// Erzeuge Komponenten für Label und Eingabefelder
		temp = new Label("Temperatur: ");
		temp.setAlignment(Pos.BASELINE_RIGHT);
		hygro = new Label("Luftfeuchtigkeit: ");
		hygro.setAlignment(Pos.BASELINE_RIGHT);
		druck = new Label("Luftdruck: ");
		druck.setAlignment(Pos.BASELINE_RIGHT);

		tf_temp = new TextField();
		tf_hygro = new TextField();
		tf_druck = new TextField();

		tf_temp.setText(((Byte) (modell.getTemperatur())).toString());
		tf_hygro.setText(((Byte) (modell.getLuftfeuchtigkeit())).toString());
		tf_druck.setText(((Integer) (modell.getLuftdruck())).toString());

		ok = new Button("OK");
		ok.setOnAction(new OK_ButtonEventHandler());

		// Füge Komponenten dem Root-Element zu:
		root.getChildren().addAll(temp, tf_temp, hygro, tf_hygro, druck, tf_druck, ok);

		// ok-Button soll mit ENTER gedrückt werden können:
		ok.setDefaultButton(true);
		
		//Stage mit Titel versehen:
		this.setTitle("Wetterstation Eingabe");
		
		//Stage mit Scene befüllen
		this.setScene(new Scene(root));
	} // Ende Konstruktor und Fensteraufbau

	// Innere Klasse, die auf den Knopfdruck reagiert:
	class OK_ButtonEventHandler implements EventHandler<ActionEvent> {
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public void handle(ActionEvent event) {
			int t, h, d;
			System.out.println("*-----------------------*");
			t = Integer.parseInt(tf_temp.getText());
			h = Integer.parseInt(tf_hygro.getText());
			d = Integer.parseInt(tf_druck.getText());
			modell.setAll(t, h, d);

		}
	}
}
