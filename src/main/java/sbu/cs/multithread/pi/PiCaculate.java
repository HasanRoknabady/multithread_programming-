package sbu.cs.multithread.pi;

import java.math.BigDecimal;
import java.math.MathContext;

public class PiCaculate extends Compute
{
    private MathContext mathContext;

    public PiCaculate(int numDigits)
    {
        super(numDigits);
        mathContext = new MathContext(numDigits);
    }

    public BigDecimal piFunction(int k) {
        int k8 = 8 * k;
        BigDecimal val1 = new BigDecimal(4);
        val1 = val1.divide(new BigDecimal(k8 + 1), mathContext);
        BigDecimal val2 = new BigDecimal(-2);
        val2 = val2.divide(new BigDecimal(k8 + 4), mathContext);
        BigDecimal val3 = new BigDecimal(-1);
        val3 = val3.divide(new BigDecimal(k8 + 5), mathContext);
        BigDecimal val4 = new BigDecimal(-1);
        val4 = val4.divide(new BigDecimal(k8 + 6), mathContext);

        BigDecimal val = val1;
        val = val.add(val2);
        val = val.add(val3);
        val = val.add(val4);
        BigDecimal multiplier = new BigDecimal(16);

        multiplier = multiplier.pow(k);
        BigDecimal one = new BigDecimal(1);
        multiplier = one.divide(multiplier, mathContext);
        val = val.multiply(multiplier);

        return val;
    }

}
