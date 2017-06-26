package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class R extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // R -> + E | < E | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{ new TokenElement(TokenType.OP_ARITHMETIC_ADD), new E() }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.OP_RELATIONAL_SMALLER_THAN), new E() }),
                Arrays.asList(new Element[]{ new Lambda() })
        );
    }
    public int getRuleIndex() {
        return 46;
    }

}
