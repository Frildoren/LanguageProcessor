package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;

import java.util.Arrays;
import java.util.List;

public class P extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        // P -> F Z P | B Z P | Z P
        return Arrays.asList(
                Arrays.asList(new Element[]{ new F(), new Z(), new P() }),
                Arrays.asList(new Element[]{ new B(), new Z(), new P() }),
                Arrays.asList(new Element[]{ new Z(), new P() })
        );
    }


}
