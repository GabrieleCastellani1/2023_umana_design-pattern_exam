import java.util.Iterator;

public class OutputFormatter {

    private int res;
    public String formatResult(Result result) {
        Iterator<Integer> resultIterator = result.resultIterator();
        String first = findResult(resultIterator);
        String second = findRemainder(resultIterator);
        return first + second;
    }

    private String findResult(Iterator<Integer> resultIterator) {
        if(resultIterator.hasNext()){
            res = resultIterator.next();
            int pound = getPound(res);
            int shelling = getShelling(res);
            int pence = res;
            return pound + "p " + shelling + "s " + pence + "d ";
        }else{
            return "non è presente alcun risultato";
        }
    }

    private String findRemainder(Iterator<Integer> resultIterator) {
        if(resultIterator.hasNext()){
            res = resultIterator.next();
            int pound = getPound(res);
            int shelling = getShelling(res);
            int pence = res;
            return "(" + pound + "p " + shelling + "s " + pence + "d" + ")";
        }else{
            return "";
        }
    }

    private int getShelling(Integer i) {
        int result = 0;
        if (i > 0) {
            while (i >= 12) {
                result += 1;
                i -= 12;
            }
            res = i;
            return result;
        }else{
            while (i <= -12) {
                result += 1;
                i += 12;
            }
            res = i;
            return result;
        }
    }

    private int getPound(Integer i) {
        int result = 0;
        if(i > 0){
            while (i >= 240) {
                result += 1;
                i -= 240;
            }
            res = i;
            return result;
        }else{
            while (i <= -240) {
                result += 1;
                i += 240;
            }
            res = i;
            return result;
        }
    }
}
