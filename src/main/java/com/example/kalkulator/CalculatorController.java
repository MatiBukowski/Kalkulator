package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static java.lang.Math.sqrt;

public class CalculatorController {
    private MainController mainController;

    @FXML
    public void exitCalculator() {
        mainController.loadMenuScene();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private Label result;
    private String operator = "";
    private String PomOperator = "";
    private double n1 = 0;
    private double pom = 0;
    private boolean start = true;
    private Model model = new Model();
    private int HowManyOperators = 0;
    private String PomNumberValue = "";
    private double pomn2 = 0;

    @FXML
    public void numbers(ActionEvent e) {
        if (start == true) {
            result.setText("");
            start = false;
        }

        String NumberValue = ((Button) e.getSource()).getText();
        result.setText(PomNumberValue + NumberValue);
        PomNumberValue = PomNumberValue + NumberValue;
    }

    @FXML
    public void operators(ActionEvent e) {
        String OperatorValue = ((Button) e.getSource()).getText();
        pom = n1;
        PomNumberValue = "";
        if (!OperatorValue.equals("AC") && !OperatorValue.equals("+/-") && !OperatorValue.equals("sqrt")) {
            if (!OperatorValue.equals("=")) {
                operator = OperatorValue;
                HowManyOperators++;

                if (HowManyOperators < 2) {
                    n1 = Double.valueOf(result.getText());
                } else {
                    double n2 = Double.valueOf(result.getText());
                    double AfterCalculate = model.calculate(pom, n2, PomOperator);
                    n1 = AfterCalculate;
                    result.setText(String.valueOf(AfterCalculate));
                }
                PomOperator = operator;
            } else {
                double n2 = Double.valueOf(result.getText());
                double AfterCalculate = model.calculate(n1, n2, operator);
                result.setText(String.valueOf(AfterCalculate));
                n1 = AfterCalculate;
                HowManyOperators = 0;
            }
        } else if (OperatorValue.equals("AC")) {
            result.setText("0");
            n1 = 0;
            HowManyOperators = 0;
        } else if (OperatorValue.equals("+/-")) {
            n1 *= -1;
            result.setText(String.valueOf(n1));
            HowManyOperators = 0;
//             if(HowManyOperators>2) {
//                 double n2 = Long.parseLong(result.getText());
//                 double AfterCalculate = model.calculate(n1, n2, PomOperator);
//                 AfterCalculate *= -1;
//                 result.setText(String.valueOf(AfterCalculate));
//                 n1 = AfterCalculate;
//             }
//             else {
//                 n1 = Long.parseLong(result.getText());
//                 n1*=-1;
//                 result.setText(String.valueOf(n1));
//             }
//            HowManyOperators = 0;
        } else if (OperatorValue.equals("sqrt")) {

            n1 = Double.valueOf(result.getText());
            n1 = sqrt(n1);
            result.setText(String.valueOf(n1));
            HowManyOperators = 0;

        }

    }

    @FXML
    private Label information;
    @FXML
    public void mouseEnteredCalculator() {
        information.setText("Aby pierwiastek oraz zmiana znaku \ndziałały poprawnie \nnależy ich używać \npo wciśnięciu symbolu =");
    }
    @FXML
    public void mouseExitedCalculator() {
        information.setText("");
    }
}
