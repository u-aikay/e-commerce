package operationexceptions;

public class StockNoLongerExistException extends Exception {
    public StockNoLongerExistException (String error) {super(error);}
}
