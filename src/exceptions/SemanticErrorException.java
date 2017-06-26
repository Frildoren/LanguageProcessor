package exceptions;

public class SemanticErrorException extends PDLException {
    public SemanticErrorException(String error) {
        super("Semantic error: "+error);
    }
}
