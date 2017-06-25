package exceptions;

public class SyntaxErrorException extends PDLException {
    public SyntaxErrorException(String unexpectedSymbol, String expected){
        this(unexpectedSymbol + ", expected: " + expected);
    }
    public SyntaxErrorException(String unexpectedSymbol){
        super("Syntax error, unexpected " + unexpectedSymbol);
    }
}
