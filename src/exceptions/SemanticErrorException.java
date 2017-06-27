package exceptions;

public class SemanticErrorException extends PDLException {
    public SemanticErrorException(String error, int line) {
        super("Semantic error: "+error, line);
    }
}
