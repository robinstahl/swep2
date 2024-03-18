package com.example.swep2;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l = new Label("Sie haben FX erfolgreich installiert!");
        l.setAlignment(Pos.BASELINE_CENTER);
        primaryStage.setScene(new Scene(l, 400,150));
        primaryStage.setTitle("Herzlichen Glückwunsch");
        primaryStage.show();
    }


}
