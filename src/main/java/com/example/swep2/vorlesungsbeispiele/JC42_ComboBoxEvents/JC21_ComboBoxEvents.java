package com.example.swep2.vorlesungsbeispiele.JC42_ComboBoxEvents;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JC21_ComboBoxEvents extends Application {

	String comboBoxListe[] = { "Baden-Württemberg", "Bayern", "Berlin", "Brandenburg", "Bremen", "Hamburg", "Hessen",
			"Mecklenburg-Vorpommern", "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen",
			"Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen" };
	int cellcounter = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll(comboBoxListe);
		combo.getSelectionModel().select(0);

		combo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(combo.getSelectionModel().getSelectedItem());
			}
		});

		combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("old value: " + oldValue);
				System.out.println("new value: " + newValue);
			}

		});
		combo.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER)
				System.out.println("--" + combo.getSelectionModel().getSelectedItem());
		});

		// einfache Textauswahlbox
		ChoiceBox<String> choice = new ChoiceBox<>();
		choice.getItems().addAll(comboBoxListe);
		choice.getSelectionModel().select(0);
		choice.setOnAction(e -> System.out.println("Choice: " + choice.getSelectionModel().getSelectedItem()));

		// umfangreiche Farb-Rechteckauswahlbox
		ComboBox<Color> cmb = new ComboBox<>();
		cmb.getItems().addAll(Color.RED, Color.DARKGREEN, Color.YELLOW, Color.ALICEBLUE, Color.BLUEVIOLET);
		cmb.setVisibleRowCount(3);
		cmb.setButtonCell(new ListCell<>() {
			private final Rectangle rectangle;
			// Exemplarinitialisierungsblock!!! statt Konstruktor
			{
				// setContentDisplay(ContentDisplay.TEXT_ONLY);
				setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
				rectangle = new Rectangle(15, 15);
			}

			@Override
			protected void updateItem(Color item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					// setText("k.a.");
					setGraphic(null);
				} else {
					// this.setTextFill(item);
					// setText("test");
					rectangle.setFill(item);
					setGraphic(rectangle);
				}
			}
		});

		cmb.setCellFactory(p -> {
			return new ListCell<>() {
				private final Rectangle rectangle;
				// Exemplarinitialisierungsblock!!! statt Konstruktor
				{
					setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
					rectangle = new Rectangle(10, 10);
				}

				@Override
				protected void updateItem(Color item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setGraphic(null);
					} else {
						rectangle.setFill(item);
						setGraphic(rectangle);
					}
				}
			};
		});

		// so sollte man das nicht machen:
		ComboBox<Rectangle> cmb2 = new ComboBox<>();
		cmb2.setItems(FXCollections.observableArrayList(new Rectangle(10, 10, Color.RED),
				new Rectangle(10, 10, Color.GREEN), new Rectangle(10, 10, Color.BLUE)));

		VBox root = new VBox(combo);
		root.getChildren().addAll(choice, cmb, cmb2);
		Scene scene = new Scene(root, 300, 100);
		stage.setScene(scene);
		stage.show();
	}

}
