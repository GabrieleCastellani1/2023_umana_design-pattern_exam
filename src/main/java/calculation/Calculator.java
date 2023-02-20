package calculation;

import exceptions.BadFormatException;

public class Calculator {

    private static Calculator calculatorInstance;

    private Calculator() {
    }

    public static Calculator getInstance(){
        if(calculatorInstance == null){
            calculatorInstance = new Calculator();
        }
        return calculatorInstance;
    }

    public Result doOperation(Operation operation) throws BadFormatException {
        Integer firstArgument = operation.getFirstArgument();
        Integer secondArgument = operation.getSecondArgument();
        switch (operation.getOperation()) {
            case ADD:
                return new Result(firstArgument + secondArgument);
            case SUBTRACT:
                return new Result(firstArgument - secondArgument);
            case DIVIDE:
                return new Result(firstArgument / secondArgument, firstArgument % secondArgument);
            case MULTIPLY:
                return new Result(firstArgument * secondArgument);
            default:
                throw new BadFormatException("non esiste una simile operazione");
        }
    }
}
