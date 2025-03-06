import java.math.BigDecimal;

public class CalculatorLogic {

    public BigDecimal add(BigDecimal a, BigDecimal b){
        return a.add(b);
    }
    public BigDecimal subtract(BigDecimal a, BigDecimal b){
        return a.subtract(b);
    }
    public BigDecimal multiply(BigDecimal a, BigDecimal b){
        return a.multiply(b);
    }
    public BigDecimal divide(BigDecimal a, BigDecimal b){
        return a.divide(b);
    }
}
