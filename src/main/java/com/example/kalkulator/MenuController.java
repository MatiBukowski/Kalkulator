package com.example.kalkulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {
    private MainController mainController;
    @FXML
    public void openCalculator() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/CalculatorScreen.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        CalculatorController calculatorController = loader.getController();
        calculatorController.setMainController(mainController);

        mainController.setMainStackPane(pane);
    }

    @FXML
    public void openConverter() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/ConverterScreen.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        ConvertController convertController = loader.getController();
        convertController.setMainController(mainController);

        mainController.setMainStackPane(pane);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}
