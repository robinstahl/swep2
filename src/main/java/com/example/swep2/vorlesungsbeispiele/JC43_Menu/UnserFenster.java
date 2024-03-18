package com.example.swep2.vorlesungsbeispiele.JC43_Menu;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UnserFenster extends javafx.application.Application {
	private MeinEventHandler evHndlr;
	private Label lab, text;
	private BorderPane root;
	private TilePane tilepane;
	private MenuBar mbar;
	private Menu m;
	private MenuItem mitem;
	
	public class MeinEventHandler implements EventHandler<ActionEvent>{
		private SimpleBooleanProperty isBackground = new SimpleBooleanProperty(false);
		private SimpleBooleanProperty isBckGray = new SimpleBooleanProperty(false);
		private SimpleBooleanProperty isBckGreen = new SimpleBooleanProperty(false);
		
		@Override
		public void handle(ActionEvent event) {
			String s = (String) ((MenuItem)(event.getTarget())).getUserData();
			if (s == "MT") text.setText("Mein Text");
			if (s == "SE") text.setText("Schöner Eintrag");
			if (s == "TE") text.setText("Tue etwas");
			if (s == "G") text.setTextFill(Color.YELLOW);
			if (s == "B") text.setTextFill(Color.BLUE);
			if (s == "R") text.setTextFill(Color.RED);
			if (isBackground.get()) {
				if (isBckGray.get())
					text.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
				else if (isBckGreen.get())
					text.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
			}
			else
				text.setBackground(null);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		evHndlr = new MeinEventHandler();
		createMenuBar();
		
		//Beschreibung:
		tilepane = new TilePane(Orientation.HORIZONTAL);
		tilepane.setPrefColumns(2);
		lab = new Label("Auswahl im Menü: ");
		text = new Label();
		text.setText("Noch nichts ausgewählt");
		tilepane.getChildren().addAll(lab, text);
		root = new BorderPane();
		//Mac?
		//mbar.setUseSystemMenuBar(true);
		root.setTop(mbar);
		root.setCenter(tilepane);
		
		primaryStage.setScene(new Scene(root,400,300));
		primaryStage.show();
	}
	

	private void createMenuBar() {
		// Erzeuge Menueleiste
		mbar = new MenuBar();
		
		//Menue1:
		// Erzeuge Menue
		m = new Menu("Texte");
		
		// Erzeuge Menueeintrag
		mitem = new MenuItem("Mein Text");
		mitem.setUserData("MT");
		mitem.setOnAction(evHndlr);
		// Haenge Menueeintrag in das Menue 
		m.getItems().add(mitem);
		
		mitem = new MenuItem("Schöner Eintrag");
		mitem.setUserData("SE");
		mitem.setOnAction(evHndlr);
		m.getItems().add(mitem);
		
		m.getItems().add(new SeparatorMenuItem());
		
		mitem = new MenuItem("Tue etwas");
		mitem.setUserData("TE");
		mitem.setOnAction(evHndlr);
		m.getItems().add(mitem);
		
		// Menue wird an Menueleiste angehaengt
		mbar.getMenus().add(m);
		
		//Menue2:
		m = new Menu("Farben");
		mitem = new MenuItem("Gelb");
		mitem.setUserData("G");
		mitem.setOnAction(evHndlr);
		m.getItems().add(mitem);
		
		mitem = new MenuItem("Blau");
		mitem.setUserData("B");
		mitem.setOnAction(evHndlr);
		m.getItems().add(mitem);
		
		mitem = new MenuItem("Rot");
		mitem.setUserData("R");
		mitem.setOnAction(evHndlr);
		m.getItems().add(mitem);

		// auch Checkbox- und RadiobuttonMenuItems sind möglich:
		m.getItems().add(new SeparatorMenuItem());
		ToggleGroup bg = new ToggleGroup();
		
		RadioMenuItem rmitem = new RadioMenuItem("Gray Background");
		rmitem.setOnAction(evHndlr);
		rmitem.setToggleGroup(bg);
		rmitem.selectedProperty().bindBidirectional(evHndlr.isBckGray);
		m.getItems().add(rmitem);
		
		rmitem = new RadioMenuItem("Green Background");
		rmitem.setOnAction(evHndlr);
		rmitem.setToggleGroup(bg);
		rmitem.selectedProperty().bindBidirectional(evHndlr.isBckGreen);
		m.getItems().add(rmitem);

		m.getItems().add(new SeparatorMenuItem());
		CheckMenuItem cmitem = new CheckMenuItem("Fill Background");
		cmitem.setOnAction(evHndlr);
		cmitem.selectedProperty().bindBidirectional(evHndlr.isBackground);
		m.getItems().add(cmitem);

		mbar.getMenus().add(m);
	}
}
