package exceptions;

public class SymbolNotFoundException extends PDLException {
    public SymbolNotFoundException() {
        super("Symbol not found");
    }

    public SymbolNotFoundException(String error) {
        super(error);
    }

    public SymbolNotFoundException(Exception e) {
        super(e);
    }
}
