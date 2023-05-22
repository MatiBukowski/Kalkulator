package com.example.kalkulator;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConvertController {
    private MainController mainController;

    @FXML
    public void exitConverter() {
        mainController.loadMenuScene();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private ChoiceBox length1id;
    @FXML
    private ChoiceBox length2id;
    @FXML
    private Label lengthResult;
    @FXML
    private TextField text;

    ObservableList<String> lengthChoice = FXCollections.observableArrayList("metry", "mile", "cale");

    public void initialize() {
        lengthOperation();
    }

    public void lengthOperation() {
        length1id.setValue("metry");
        length2id.setValue("mile");

        length1id.setItems(lengthChoice);
        length2id.setItems(lengthChoice);
    }

    @FXML
    public void convert() {
        double value = Double.valueOf(text.getText());

        if(length1id.getValue().equals("metry") && length2id.getValue().equals("mile")) {
            value = value*0.000621371192;
            lengthResult.setText(String.valueOf(value));
        }
        else if(length1id.getValue().equals("metry") && length2id.getValue().equals("cale")) {
            value = value*39.3700787;
            lengthResult.setText(String.valueOf(value));
        }
        else if(length1id.getValue().equals("mile") && length2id.getValue().equals("metry")) {
            value = value*1609.344;
            lengthResult.setText(String.valueOf(value));
        }
        else if(length1id.getValue().equals("mile") && length2id.getValue().equals("cale")) {
            value = value*63360 ;
            lengthResult.setText(String.valueOf(value));
        }
        else if(length1id.getValue().equals("cale") && length2id.getValue().equals("metry")) {
            value = value*0.0254 ;
            lengthResult.setText(String.valueOf(value));
        }
        else if(length1id.getValue().equals("cale") && length2id.getValue().equals("mile")) {
            value = value*0.000015782828 ;
            lengthResult.setText(String.valueOf(value));
        }
        else
            lengthResult.setText(String.valueOf(value));
    }

}
