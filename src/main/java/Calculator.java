import exceptions.BadFormatException;

public class Calculator {

    public Calculator() {}

    public Result doOperation(Operation operation) throws BadFormatException {
        Integer firstArgument = operation.getFirstArgument();
        Integer secondArgument = operation.getSecondArgument();
        switch (operation.getOperation()){
            case ADD: return new Result(firstArgument + secondArgument);
            case SUBTRACT: return new Result(firstArgument - secondArgument);
            case DIVIDE: return new Result(firstArgument/secondArgument, firstArgument%secondArgument);
            case MULTIPLY: return new Result(firstArgument * secondArgument);
            default: throw new BadFormatException("non esiste una simile operazione");
        }
    }
}
