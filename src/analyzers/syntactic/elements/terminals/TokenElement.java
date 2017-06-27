package analyzers.syntactic.elements.terminals;

import analyzers.syntactic.elements.TerminalElement;
import enums.TokenType;
import structures.Symbol;

public class TokenElement extends TerminalElement implements Symbol {

    private final TokenType tokenType;

    public TokenElement(TokenType tokenType){
        this.tokenType = tokenType;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        try {
            TokenElement that = (TokenElement) o;
            return tokenType == that.tokenType;
        } catch (ClassCastException e){
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tokenType != null ? tokenType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getTokenType().toString();
    }
}
