package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static sample.Model.Operation.*;

public class Controller {

    private Model model = new Model();
    private boolean isNewNumber = true;

    @FXML
    TextField display;

    @FXML
    private void digitAction(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (value.equals("0") && display.getText().equals("0")) {
            return;
        }
        if (value.equals(".")) {
            if (isNewNumber) {
                value = "0.";
            }
            if (display.getText().contains(".")) {
                return;
            }
        }
        if (isNewNumber) {
            display.clear();
            isNewNumber = false;
        }
        display.setText(display.getText() + value);
    }

    @FXML
    private void operationAction(ActionEvent event) {
        String displayText = display.getText();
        int index = displayText.length() - 1;
        if (displayText.charAt(index) == '.') {
            displayText = displayText.substring(0, index);
        }
        model.setFirstOperand(Double.parseDouble(displayText));
        display.setText(displayText);
        String value = ((Button) event.getSource()).getText();
        switch (value) {
            case "+":
                model.setOperation(addition);
                break;
            case "-":
                if (isNewNumber) {
                    display.setText(value);
                    isNewNumber = false;
                    return;
                } else {
                    model.setOperation(subtraction);
                }
                break;
            case "*":
                model.setOperation(multiplication);
                break;
            case "/":
                model.setOperation(division);
                break;
        }
        isNewNumber = true;
    }

    @FXML
    private void resultAction() {
        if (isNewNumber) {
            model.setFirstOperand(Double.parseDouble(display.getText()));
        } else {
            model.setSecondOperand(Double.parseDouble(display.getText()));
        }
        double result = model.calculate();
        display.setText(String.valueOf(result));
        isNewNumber = true;
    }
}
