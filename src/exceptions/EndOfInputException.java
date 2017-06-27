package exceptions;


public class EndOfInputException extends PDLException {
    public EndOfInputException(int errorLine) {
        super("End of input", errorLine);
    }
}
