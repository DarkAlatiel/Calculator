package sample;

public class Model {

    public enum Operation {addition, subtraction, multiplication, division}

    private double firstOperand;
    private double secondOperand;
    private Operation operation;

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate() {
        double result = Double.NaN;
        switch (operation) {
            case addition:
                result = firstOperand + secondOperand;
                break;
            case subtraction:
                result = firstOperand - secondOperand;
                break;
            case multiplication:
                result = firstOperand * secondOperand;
                break;
            case division:
                result = firstOperand / secondOperand;
                break;
        }
        return result;
    }

}
