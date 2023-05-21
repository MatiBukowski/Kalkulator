package com.example.kalkulator;

import javafx.fxml.FXML;

public class ConvertController {
    private MainController mainController;

    @FXML
    public void exitConverter() {
        mainController.loadMenuScene();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
