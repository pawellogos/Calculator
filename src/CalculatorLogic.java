import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
    public BigDecimal second_pow(BigDecimal a){
        return a.pow(2);
    }
    public BigDecimal one_divide_byx(BigDecimal a){
    BigDecimal x = new BigDecimal(1);
        BigDecimal result = x.divide(a);
        return result;
    }
    public BigDecimal power(BigDecimal a, BigDecimal b){
        BigDecimal pow = a.pow(b.intValueExact());
        return pow;
    }
    public BigDecimal factorial(BigDecimal a){
        if (a.compareTo(BigDecimal.ONE) <= 0){
            return BigDecimal.ONE;
        }
        return a.multiply(factorial(a.subtract(BigDecimal.ONE)));
    }
    public BigDecimal sqrt_second (BigDecimal a){
        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(Math.sqrt(a.doubleValue()), mc);
        return result;
    }

}
