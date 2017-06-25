package analyzers.syntactic.elements;

public abstract class BaseElement implements Element {

    @Override
    public boolean equals(Object o) {
        return getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
