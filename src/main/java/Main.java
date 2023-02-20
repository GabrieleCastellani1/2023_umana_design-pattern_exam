import exceptions.BadFormatException;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Translater translater = Translater.getInstance();
        OutputFormatter formatter = OutputFormatter.getInstance();
        String operation = args[0];
        try {
            String result = formatter.formatResult(calc.doOperation(translater.translate(operation)));
            System.out.println(result);
        } catch (BadFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}
