package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class E extends NotTerminalElement {


    @Override
    public List<List<Element>> getBranchesClasses() {
        // E -> ! E | V R | true | false
        return Arrays.asList(
                Arrays.asList(new Element[]{ new TokenElement(TokenType.OP_LOGIC_NEGATION), new E() }),
                Arrays.asList(new Element[]{ new V(), new R() }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.TRUE) }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.FALSE) })
        );
    }

    public int getRuleIndex() {
        return 42;
    }

}
