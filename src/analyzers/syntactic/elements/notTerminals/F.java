package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class F extends NotTerminalElement {
    public List<List<Element>> getBranchesClasses() {
        // F -> function H id ( A ) Z { Z C }
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.FUNCTION),
                        new H(),
                        new TokenElement(TokenType.IDENTIFIER),
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new A(),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS),
                        new Z(),
                        new TokenElement(TokenType.OPEN_BRACE),
                        new Z(),
                        new C(),
                        new TokenElement(TokenType.CLOSE_BRACE)
                })
        );
    }

    public int getRuleIndex() {
        return 10;
    }
}
