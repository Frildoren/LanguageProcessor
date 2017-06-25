package analyzers.syntactic.elements;

import java.util.List;

public interface Element {
    List<Element> getFirst();
    List<Element> getFirst(List<Class<? extends Element>> done);
}
