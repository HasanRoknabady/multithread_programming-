package sbu.cs.multithread.pi;

public class PICalculator {

    /**
     * calculate pi and represent it as string with given floating point number (numbers after .)
     * check test cases for more info
     * check pi with 1000 digits after floating point at https://mathshistory.st-andrews.ac.uk/HistTopics/1000_places/
     *
     * @param floatingPoint number of digits after floating point
     * @return pi in string format
     */
    public String calculate(int floatingPoint)
    {
        Compute calculate = new Compute(floatingPoint+2);

        try
        {
            StringBuilder out = new StringBuilder(calculate.compute().toString());
            String strOut = out.deleteCharAt(out.length()-1).toString();
            return strOut;
        }
        catch (InterruptedException exception) {
            return exception.getMessage();
        }

    }
}
