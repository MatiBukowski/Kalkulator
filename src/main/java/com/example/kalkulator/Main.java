package com.example.kalkulator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/MainScreen.fxml"));
        StackPane stackpane = loader.load();
        Scene scene = new Scene(stackpane, 500, 600);
        stage.setScene(scene);
        stage.setTitle("Wielofunkcyjna aplikacja");
        stage.show();

    }
}
