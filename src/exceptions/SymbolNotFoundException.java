package exceptions;

public class SymbolNotFoundException extends PDLException {

    public SymbolNotFoundException(int errorLine) {
        super("Symbol not found", errorLine);
    }

    public SymbolNotFoundException(String error, int errorLine) {
        super(error, errorLine);
    }

    public SymbolNotFoundException(Exception e) {
        super(e);
    }

    public SymbolNotFoundException(String index) {
        super("Symbol not found: " + index);
    }
}
