/**
 * Created by Hunter on 2015-03-08.
 */
public class CalculatorDouble implements CalculatorDoubleImp {
    @Override
    public double add(double a, double b) {
        return a+b;
    }
    @Override
    public double sub(double a, double b) {
        return a-b;
    }
    @Override
    public double multi(double a, double b) {
        return a*b;
    }
    @Override
    public double div(double a, double b) {
        return a/b;
    }
    @Override
    public boolean greater(double a, double b) {
        if(a>b) return true;
        else return false;
    }
}