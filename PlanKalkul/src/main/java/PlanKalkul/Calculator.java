package PlanKalkul;

public class Calculator implements MathOps<Number> {
    @Override
    public double summa(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    @Override
    public double multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    @Override
    public double divide(Number a, Number b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("На ноль делить нельзя");
        }
        return a.doubleValue() / b.doubleValue();
    }

    @Override
    public double subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }
}

