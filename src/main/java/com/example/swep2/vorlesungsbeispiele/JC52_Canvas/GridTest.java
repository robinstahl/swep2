package com.example.swep2.vorlesungsbeispiele.JC52_Canvas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridTest extends Application {

//    @Override
//    public void start(Stage primaryStage) {
//        Grid grid = new Grid(10,10);
//        grid.setPadding(new Insets(20));
//        Scene scene = new Scene(grid, 400, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
    
    @Override
    public void start(Stage primaryStage) {
        Grid2 grid = new Grid2(10,10);
        Scene scene = new Scene(grid.getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}