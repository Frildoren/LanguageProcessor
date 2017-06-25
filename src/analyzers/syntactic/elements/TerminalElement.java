package analyzers.syntactic.elements;

import java.util.Arrays;
import java.util.List;

public class TerminalElement extends BaseElement {

    @Override
    public List<Element> getFirst() {
        return Arrays.asList(new Element[]{ this });
    }

    @Override
    public List<Element> getFirst(List<Class<? extends Element>> done) {
        return getFirst();
    }

}
