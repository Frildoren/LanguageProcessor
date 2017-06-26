package exceptions;

public class SyntaxErrorException extends PDLException {
    public SyntaxErrorException(String unexpectedSymbol, String expected, int errorLine){
        this(unexpectedSymbol + ", expected: " + expected, errorLine);
    }
    public SyntaxErrorException(String unexpectedSymbol, int errorLine){
        super("Syntax error, unexpected " + unexpectedSymbol, errorLine);
    }
}
