package analyzers.syntactic.elements;

import java.util.Arrays;
import java.util.List;

public class TerminalElement extends BaseElement {

    @Override
    public List<Element> getFirst() {
        return Arrays.asList(new Element[]{ this });
    }

}
