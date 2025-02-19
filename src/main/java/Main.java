import exceptions.BadFormatException;
import calculation.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.getInstance();
        InputTranslater inputTranslater = InputTranslater.getInstance();
        OutputFormatter formatter = OutputFormatter.getInstance();
        String operation = args[0];
        try {
            String result = formatter.formatResult(calc.doOperation(inputTranslater.translate(operation)));
            System.out.println(result);
        } catch (BadFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}
