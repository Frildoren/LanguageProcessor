package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class X extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //X -> E | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new E()}),
                Arrays.asList(new Element[]{
                        new Lambda()})
        );
    }
}
