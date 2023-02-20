import java.util.Iterator;

public class OutputFormatter {

    private int res;
    public String formatResult(Result result) {
        Iterator<Integer> resultIterator = result.resultIterator();
        if (resultIterator.hasNext()) {
            Integer firstResult = resultIterator.next();
            res = firstResult;
            int pound = getPound(res);
            int shelling = getShelling(res);
            int pence = res;
            String firstOutput = pound + "p " + shelling + "s " + pence + "d ";
            String secondOutput = "";

            if (resultIterator.hasNext()) {
                Integer remainder = resultIterator.next();
                int poundRemainder = getPound(remainder);
                int shellingRemainder = getShelling(remainder);
                int penceRemainder = remainder;
                secondOutput = "( " + poundRemainder + "p " + shellingRemainder + "s " + penceRemainder + "d" + " )";
            }

            return firstOutput + secondOutput;

        } else {
            return "non è presente alcun risultato";
        }
    }

    private int getShelling(Integer i) {
        int result = 0;
        while (i >= 12) {
            result += 1;
            i -= 12;
        }
        res = i;
        return result;
    }

    private int getPound(Integer i) {
        int result = 0;
        while (i >= 240) {
            result += 1;
            i -= 240;
        }
        res = i;
        return result;
    }
}
