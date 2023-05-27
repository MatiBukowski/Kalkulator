package com.example.kalkulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class NotebookController {

    MainController mainController;
    @FXML
    public void exitNotebook() {
        mainController.loadMenuScene();
    }

    void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private ChoiceBox choiceNote;
    @FXML
    private TextField titleNote;
    @FXML
    private TextArea textNote;
    @FXML
    private Label errorText;

//    ObservableList<String> titleNoteList = FXCollections.observableArrayList();
//    Map<String,String> noteList = new HashMap<>();
    ObservableList<String> titleNoteList;
    Map<String,String> noteList;

    public void choiceOperation() {
        choiceNote.setItems(titleNoteList);
    }

    @FXML
    public void choiceMouseEntered() {
        if(titleNoteList!=null) {
            choiceOperation();
        }
    }
    @FXML
    public void createNote() {
        errorText.setText("");
        titleNote.setText("");
        textNote.setText("");
        choiceNote.setValue("");
    }

    @FXML
    public void saveNote() {
        if(titleNote.getText().length() == 0) {
            errorText.setText("Podaj nazwę notatki");
        }
        else {
            errorText.setText("");

            if(noteList.containsKey(titleNote.getText())) {
                titleNoteList.remove(titleNote.getText());
                titleNoteList.add(titleNote.getText());

                noteList.remove(titleNote.getText());
                noteList.put(titleNote.getText(), textNote.getText());
            }
            else {
                titleNoteList.add(titleNote.getText());
                noteList.put(titleNote.getText(), textNote.getText());
            }

            choiceOperation();
        }
    }

    @FXML
    public void openNote() {
        errorText.setText("");
        titleNote.setText(String.valueOf(choiceNote.getValue()));
        textNote.setText(noteList.get(String.valueOf(choiceNote.getValue())));
    }

    @FXML
    public void deleteNote() {
        noteList.remove(String.valueOf(choiceNote.getValue()));
        titleNoteList.remove(choiceNote.getValue());
        titleNote.setText("");
        textNote.setText("");
        choiceNote.setValue("");
    }

    public void setTitleNoteList(ObservableList<String> titleNoteList) {
        this.titleNoteList = titleNoteList;
    }

    public void setNoteList(Map<String, String> noteList) {
        this.noteList = noteList;
    }

}
