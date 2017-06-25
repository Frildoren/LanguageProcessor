package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class K extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // K -> , T id K | lambda
        return Arrays.asList(
                Arrays.asList(
                        new TokenElement(TokenType.COMMA),
                        new T(),
                        new TokenElement(TokenType.IDENTIFIER),
                        new K()
                ),
                Arrays.asList(new Element[]{new Lambda()})
        );
    }

    public int getRuleIndex() {
        return 17;
    }

}
