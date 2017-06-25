package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;

import java.util.Arrays;
import java.util.List;

public class C extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // C -> B Z C | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{ new B(), new Z(), new C() }),
                Arrays.asList(new Element[]{ new Lambda() })
        );
    }

    public int getRuleIndex() {
        return 47;
    }

}
