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
        weightOperation();
        temperatureOperation();
    }

    public void lengthOperation() {
        length1id.setValue("metry");
        length2id.setValue("mile");

        length1id.setItems(lengthChoice);
        length2id.setItems(lengthChoice);
    }

    @FXML
    public void convertLength() {
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

    @FXML
    private ChoiceBox weight1id;
    @FXML
    private ChoiceBox weight2id;
    @FXML
    private Label weightResult;
    @FXML
    private TextField textWeight;
    ObservableList<String> weightChoice = FXCollections.observableArrayList("kilogramy", "funty", "uncje");

    public void weightOperation() {
        weight1id.setValue("kilogramy");
        weight2id.setValue("funty");

        weight1id.setItems(weightChoice);
        weight2id.setItems(weightChoice);
    }

    @FXML
    public void convertWeight() {
        double value = Double.valueOf(textWeight.getText());

        if(weight1id.getValue().equals("kilogramy") && weight2id.getValue().equals("funty")) {
            value = value*2.20462262;
            weightResult.setText(String.valueOf(value));
        }
        else if(weight1id.getValue().equals("kilogramy") && weight2id.getValue().equals("uncje")) {
            value = value*35.2739619;
            weightResult.setText(String.valueOf(value));
        }
        else if(weight1id.getValue().equals("funty") && weight2id.getValue().equals("kilogramy")) {
            value = value*0.45359237;
            weightResult.setText(String.valueOf(value));
        }
        else if(weight1id.getValue().equals("funty") && weight2id.getValue().equals("uncje")) {
            value = value*16;
            weightResult.setText(String.valueOf(value));
        }
        else if(weight1id.getValue().equals("uncje") && weight2id.getValue().equals("kilogramy")) {
            value = value*0.0283495231;
            weightResult.setText(String.valueOf(value));
        }
        else if(weight1id.getValue().equals("uncje") && weight2id.getValue().equals("funty")) {
            value = value*0.0625;
            weightResult.setText(String.valueOf(value));
        }
        else
            weightResult.setText(String.valueOf(value));
    }

    @FXML
    private ChoiceBox temperature1id;
    @FXML
    private ChoiceBox temperature2id;
    @FXML
    private Label temperatureResult;
    @FXML
    private TextField textTemperature;
    ObservableList<String> temperatureChoice = FXCollections.observableArrayList("stopnie Celcjusza", "stopnie Fahrenheita", "stopnie Kelwina");

    public void temperatureOperation() {
        temperature1id.setValue("stopnie Celcjusza");
        temperature2id.setValue("stopnie Fahrenheita");

        temperature1id.setItems(temperatureChoice);
        temperature2id.setItems(temperatureChoice);
    }

    @FXML
    public void convertTemperature() {
        double value = Double.valueOf(textTemperature.getText());

        if(temperature1id.getValue().equals("stopnie Celcjusza") && temperature2id.getValue().equals("stopnie Fahrenheita")) {
            value = 1.8*value + 32;
            temperatureResult.setText(String.valueOf(value));
        }
        else if(temperature1id.getValue().equals("stopnie Celcjusza") && temperature2id.getValue().equals("stopnie Kelwina")) {
            value = value+273.15;
            temperatureResult.setText(String.valueOf(value));
        }
        else if(temperature1id.getValue().equals("stopnie Fahrenheita") && temperature2id.getValue().equals("stopnie Celcjusza")) {
            value = (value-32)/1.8;
            temperatureResult.setText(String.valueOf(value));
        }
        else if(temperature1id.getValue().equals("stopnie Fahrenheita") && temperature2id.getValue().equals("stopnie Kelwina")) {
            value = (value-32)/1.8 + 273.15;
            temperatureResult.setText(String.valueOf(value));
        }
        else if(temperature1id.getValue().equals("stopnie Kelwina") && temperature2id.getValue().equals("stopnie Celcjusza")) {
            value = value-273.15;
            temperatureResult.setText(String.valueOf(value));
        }
        else if(temperature1id.getValue().equals("stopnie Kelwina") && temperature2id.getValue().equals("stopnie Fahrenheita")) {
            value = (value-273.15)*1.8 + 32;
            temperatureResult.setText(String.valueOf(value));
        }
        else
            temperatureResult.setText(String.valueOf(value));
    }

}

