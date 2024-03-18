package com.example.swep2.vorlesungsbeispiele.JC31_Textfelder;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TextfelderFenster extends Application {
	
	private final Label message = new Label("");
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		VBox vbox = new VBox();
		GridPane gridpane = new GridPane();
		
		Label uname = new Label("Username: ");
		uname.setStyle("-fx-font-size: 12pt;");
		
		Label passwd = new Label("Passwd: ");
		passwd.setStyle(uname.getStyle());
		
		TextField unametxt = new TextField();
		unametxt.setStyle(uname.getStyle());
		
		PasswordField passwdtxt = new PasswordField();
		passwdtxt.setStyle(uname.getStyle());
		
		passwdtxt.setOnAction(e -> {
			if(!passwdtxt.getText().contentEquals("abc")) {
				message.setText("Password is incorrect!");
				message.setTextFill(Color.RED);
			} else {
				message.setText("Password confirmed.");
				message.setTextFill(Color.BLACK);
			}
			passwdtxt.setText("");
		});
		
		message.setStyle(uname.getStyle());
		
		gridpane.addRow(0, uname, unametxt);
		gridpane.addRow(1, passwd, passwdtxt);
		
		vbox.getChildren().addAll(gridpane, message);
		root.getChildren().add(vbox);
		
		Scene loginscene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(loginscene);
		stage.show();
	}
}
