package com.example.kalkulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public void openPasswordCreator() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/PasswordCreatorScreen.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        PasswordCreatorController passwordCreatorController = loader.getController();
        passwordCreatorController.setMainController(mainController);

        mainController.setMainStackPane(pane);
    }

    @FXML
    public void openNotebook() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/kalkulator/NotebookScreen.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        NotebookController notebookController = loader.getController();
        notebookController.setMainController(mainController);

        mainController.setMainStackPane(pane);

        notebookController.setTitleNoteList(titleNoteList);
        notebookController.setNoteList(noteList);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    ObservableList<String> titleNoteList;
    Map<String,String> noteList;

    public void setTitleNoteList(ObservableList<String> titleNoteList) {
        this.titleNoteList = titleNoteList;
    }

    public void setNoteList(Map<String, String> noteList) {
        this.noteList = noteList;
    }
}
