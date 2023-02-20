import exceptions.BadFormatException;
import calculation.Operation;
import calculation.OperationEnum;

public class InputTranslater {

    private static InputTranslater inputTranslaterInstance;

    private InputTranslater() {
    }

    public static InputTranslater getInstance() {
        if (inputTranslaterInstance == null) {
            inputTranslaterInstance = new InputTranslater();
        }
        return inputTranslaterInstance;
    }

    public Operation translate(String input) throws BadFormatException {
        OperationEnum operation;
        Integer first;
        Integer second;
        if (input.contains("+")) {
            operation = OperationEnum.ADD;
            first = translateArgument(input.substring(0, input.indexOf("+")));
            second = translateArgument(input.substring(input.indexOf("+") + 2));
        } else if (input.contains("-")) {
            operation = OperationEnum.SUBTRACT;
            first = translateArgument(input.substring(0, input.indexOf("-")));
            second = translateArgument(input.substring(input.indexOf("-") + 2));
        } else if (input.contains("*")) {
            operation = OperationEnum.MULTIPLY;
            first = translateArgument(input.substring(0, input.indexOf("*")));
            second = Integer.parseInt(input.substring(input.indexOf("*") + 2));
        } else if (input.contains("/")) {
            operation = OperationEnum.DIVIDE;
            first = translateArgument(input.substring(0, input.indexOf("/")));
            second = Integer.parseInt(input.substring(input.indexOf("/") + 2));
        } else {
            throw new BadFormatException("l'input presentato non è corretto");
        }
        return new Operation(operation, first, second);
    }

    private Integer translateArgument(String argument) throws BadFormatException {
        String[] singleValues = argument.split(" ");
        int sum = 0;
        for (String value : singleValues) {
            sum += translateValue(value);
        }
        return sum;
    }

    private int translateValue(String value) throws BadFormatException {
        if (value.contains("p")) {
            return Integer.parseInt(value.substring(0, value.indexOf("p"))) * 240;
        } else if (value.contains("s")) {
            return Integer.parseInt(value.substring(0, value.indexOf("s"))) * 12;
        } else if (value.contains("d")) {
            return Integer.parseInt(value.substring(0, value.indexOf("d")));
        } else {
            throw new BadFormatException("il valore " + value + "non è conforme");
        }
    }
}
