package PlanKalkul;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello PlanKalkul!");
        int number1 = 17;
        double number2 = 5.0;
        Calculator calculator = new Calculator();

        double summaResult = calculator.summa(number1, number2);
        double multiplyResult = calculator.multiply(number1, number2);
        double divideResult = calculator.divide(number1, number2);
        double subtractResult = calculator.subtract(number1, number2);

        System.out.println("Сумма: " + summaResult);
        System.out.println("Умножение: " + multiplyResult);
        System.out.println("Деление: " + divideResult);
        System.out.println("Вычитание: " + subtractResult);
    }

}
