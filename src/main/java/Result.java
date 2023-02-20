import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Result {
    private final List<Integer> resultArguments;

    public Result(Integer... arguments) {
        this.resultArguments = Arrays.asList(arguments);
    }

    public Iterator<Integer> resultIterator() {
        return this.resultArguments.iterator();
    }
}
