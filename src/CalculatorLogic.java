
public class CalculatorLogic {

    public double add(double a, double b){
        return a + b;
    }
    public double subtract(double a, double b){
        return a - b;
    }
    public double multiply(double a, double b){
        return a * b;
    }
    public double divide(double a, double b){
        if(b == 0){
            //add Exception
        }
        return a / b;
    }
}
