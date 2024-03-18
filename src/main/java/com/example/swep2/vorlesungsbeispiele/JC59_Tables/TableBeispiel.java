package com.example.swep2.vorlesungsbeispiele.JC59_Tables;

import java.util.List;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ResizeFeaturesBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.ResizeFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableBeispiel extends Application {

	private List<Person> musician;
	private TableView<Person> table;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		musician = List.of(new Person("Herrmann", "Baumann"), new Person("Stefan", "Dohr"),
				new Person("Sarah", "Willis"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<Person> professionals = FXCollections.observableArrayList(musician);
		table = new TableView<Person>();
		table.setItems(professionals);

		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName")); //Property-Name!!

		TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		TableColumn<Person, Number> nameLenCol = new TableColumn<>("Name Length");
		nameLenCol.setCellValueFactory(new Callback<CellDataFeatures<Person, Number>, ObservableValue<Number>>() {
			@Override
			public ObservableValue<Number> call(CellDataFeatures<Person, Number> param) {
				// param.getValue() returns the Person instance of current TableView row
				Person p = param.getValue();
				return new SimpleIntegerProperty(p.getLastName().length());
			}
			
		});
		
		firstNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
		firstNameCol.setResizable(false);
		lastNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.5));
		nameLenCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		//or
//		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		table.getColumns().setAll(firstNameCol, lastNameCol, nameLenCol);
		table.setContextMenu(createContextMenu());
		
		table.setTableMenuButtonVisible(true); //disabling/enabling columns by button

		primaryStage.setScene(new Scene(table));
		primaryStage.setTitle("Table");
		primaryStage.show();
	}
	
	private ContextMenu createContextMenu() {
		ContextMenu ctxMenu = new ContextMenu();
		MenuItem helpMI = new MenuItem("help...");
		helpMI.setOnAction(e -> {
			System.out.println(table.getSelectionModel().getSelectedItem());
		});
		ctxMenu.getItems().add(helpMI);
		return ctxMenu;
	}

}
