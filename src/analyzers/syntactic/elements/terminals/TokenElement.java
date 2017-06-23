package analyzers.syntactic.elements.terminals;

import analyzers.syntactic.elements.TerminalElement;
import enums.TokenType;

public class TokenElement extends TerminalElement {

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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TokenElement that = (TokenElement) o;

        return tokenType == that.tokenType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tokenType != null ? tokenType.hashCode() : 0);
        return result;
    }
}
