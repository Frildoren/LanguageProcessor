package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class P extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        // P -> F P | B P | Z P | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{ new F(), new P() }),
                Arrays.asList(new Element[]{ new B(), new P() }),
                Arrays.asList(new Element[]{ new Z(), new P() }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.EOF)})
        );
    }

    public int getRuleIndex() {
        return 1;
    }

}
