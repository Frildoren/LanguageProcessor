package analyzers.syntactic.elements.notTerminals;


import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class T extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // T -> int | bool | chars
        return Arrays.asList(
                Arrays.asList(new Element[] {new TokenElement(TokenType.INT)}),
                Arrays.asList(new Element[] {new TokenElement(TokenType.BOOL)}),
                Arrays.asList(new Element[] {new TokenElement(TokenType.CHARS)})
        );
    }

    public int getRuleIndex() {
        return 6;
    }

}
