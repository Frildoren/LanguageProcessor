package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class Y extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        //  Y -> eol Y | ; Y | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{ new TokenElement(TokenType.NEW_LINE), new Y() }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.SEMICOLON), new Y() }),
                Arrays.asList(new Element[]{ new Lambda() })
        );
    }

    public int getRuleIndex() {
        return 3;
    }

}
