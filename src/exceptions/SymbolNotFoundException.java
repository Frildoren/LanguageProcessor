package exceptions;

public class SymbolNotFoundException extends PDLException {

    public SymbolNotFoundException() { super("Symbol not found"); }

    public SymbolNotFoundException(int errorLine) {
        super("Symbol not found", errorLine);
    }

    public SymbolNotFoundException(String error, int errorLine) {
        super(error, errorLine);
    }

    public SymbolNotFoundException(Exception e) {
        super(e);
    }
}
