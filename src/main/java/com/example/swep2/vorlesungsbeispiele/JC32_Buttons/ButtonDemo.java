package com.example.swep2.vorlesungsbeispiele.JC32_Buttons;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox(); 
		HBox buttonBox1 = new HBox(); //for buttons in first row
		HBox buttonBox2 = new HBox(); //for buttons in second row
		HBox buttonBox3 = new HBox(); //               third
		HBox buttonBox4 = new HBox(); //               fourth
		
		//Buttons in the first line
		Button button1 = new Button("Schaltfläche 1");
		Button button2 = new Button("Die zweite Schaltfläche");
		Button button3 = new Button("Die dritte");
		
		//Hintergrundfarbe des Buttons ändern - nicht mit setBackground()!
		//button2.setStyle("-fx-base: #b6e7c9;");
		//button2.setStyle("-fx-background-color: #b6e7c9;"); // nicht schön, Effekte gehen verloren
		
		button1.setFont(Font.font(16));
		button2.setFont(Font.font(16));
		button3.setFont(Font.font(16));
		
		buttonBox1.getChildren().addAll(button1, button2, button3);
		buttonBox1.setPadding(new Insets(5,5,5,5)); // distance to the edges
		buttonBox1.setSpacing(10); // distance between buttons
		buttonBox1.setAlignment(Pos.CENTER);
		
		//Buttons in the second line
		ToggleButton tglbutton1 = new ToggleButton("Vier");
		ToggleButton tglbutton2 = new ToggleButton("5");
		
		tglbutton1.setFont(Font.font(16));
		tglbutton2.setFont(Font.font(16));
		
		buttonBox2.getChildren().addAll(tglbutton1, tglbutton2);
		buttonBox2.setPadding(new Insets(5,5,5,5));
		buttonBox2.setSpacing(10);
		buttonBox2.setAlignment(Pos.BASELINE_CENTER);
//		BorderStroke borderstroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, BorderStroke.DEFAULT_WIDTHS);
//		Border schwarzeLinie = new Border(borderstroke);
//		buttonBox2.setBorder(schwarzeLinie);
		
		//Buttons in the third line
		CheckBox chkbox1 = new CheckBox("Zum Auswählen.");
		CheckBox chkbox2 = new CheckBox("Auch hier wählen wir aus.");
		
		chkbox1.setFont(Font.font(16));
		chkbox2.setFont(Font.font(16));
		
		buttonBox3.getChildren().addAll(chkbox1, chkbox2);
		buttonBox3.setPadding(new Insets(5,5,5,5));
		buttonBox3.setSpacing(10);;
		buttonBox3.setAlignment(Pos.BASELINE_CENTER);
		
		//Buttons in the fourth line
		RadioButton rbutton1 = new RadioButton("Hier spielt die Musik.");
		RadioButton rbutton2 = new RadioButton("hier auch.");
		RadioButton rbutton3 = new RadioButton("und hier auch.");
		ToggleGroup tbg = new ToggleGroup();
		rbutton1.setToggleGroup(tbg);
		rbutton2.setToggleGroup(tbg);
		rbutton3.setToggleGroup(tbg);
		
		rbutton1.setFont(Font.font(16));
		rbutton2.setFont(Font.font(16));
		rbutton3.setFont(Font.font(16));
		
		buttonBox4.getChildren().addAll(rbutton1, rbutton2, rbutton3);
		buttonBox4.setPadding(new Insets(5,5,5,5));
		buttonBox4.setSpacing(10);
		buttonBox4.setAlignment(Pos.CENTER);
		
		root.getChildren().addAll(buttonBox1, buttonBox2, buttonBox3, buttonBox4);
		Scene buttonscene = new Scene(root);
		stage.setTitle("ButtonDemo");
		stage.setScene(buttonscene);
		stage.show();
	}

}
