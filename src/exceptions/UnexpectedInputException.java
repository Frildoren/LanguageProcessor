package exceptions;


public class UnexpectedInputException extends PDLException {
    public UnexpectedInputException(String s, int errorLine) {
        super(s, errorLine);
    }
}
