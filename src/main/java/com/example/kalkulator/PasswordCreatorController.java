package com.example.kalkulator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class PasswordCreatorController {
    MainController mainController;

    @FXML
    public void exitPasswordCreator() {
        mainController.loadMenuScene();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TextField textPassword;
    @FXML
    private Label resultPassword;

    private ArrayList<String> charactersList = new ArrayList<>();
    private String[] specialCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "[", "]", "{", "}", "|", "\\",
            ":", ";", "\"", "'", "<", ">", ",", ".", "/", "?"};

    @FXML
    public void createPassword() {
        CharactersListOperation();
        Random generator = new Random();
        String help = "";

        try {
            int value = Integer.valueOf(textPassword.getText());

            for(int i=0; i<value; i++) {
                resultPassword.setText(help + charactersList.get(generator.nextInt(charactersList.size())));
                help = resultPassword.getText();
            }
        }
        catch (NumberFormatException e) {
            resultPassword.setText("Błąd - wprowadź liczbę naturalną");
        }
    }

    private void CharactersListOperation() {
        for(int i=0; i<=9; i++)
            charactersList.add(String.valueOf(i));

        for(char i='a'; i<='z'; i++)
            charactersList.add(String.valueOf(i));

        for(char i='A'; i<='Z'; i++)
            charactersList.add(String.valueOf(i));

        for(String specialCharacters: specialCharacters)
            charactersList.add(specialCharacters);
    }
}
