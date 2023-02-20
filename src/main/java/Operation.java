public class Operation {
    private final OperationEnum operation;
    private final Integer firstArgument;
    private final Integer secondArgument;

    public Integer getFirstArgument() {
        return firstArgument;
    }

    public Integer getSecondArgument() {
        return secondArgument;
    }

    public Operation(OperationEnum operation, Integer firstArgument, Integer secondArgument) {
        this.operation = operation;
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }


    public OperationEnum getOperation() {
        return operation;
    }
}
