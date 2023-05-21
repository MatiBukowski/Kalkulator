package com.example.kalkulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {
    @FXML
    private StackPane mainStackPane;

    @FXML
    void initialize() {
        loadMenuScene();
    }
    public void loadMenuScene() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/MenuScreen.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        MenuController menuController = loader.getController();
        menuController.setMainController(this);

        setMainStackPane(pane);
    }
    public void setMainStackPane(Pane pane){
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
