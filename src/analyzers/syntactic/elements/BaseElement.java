package analyzers.syntactic.elements;

import analyzers.semantic.SemanticAnalyzer;
import structures.Token;

public abstract class BaseElement implements Element {

    @Override
    public boolean equals(Object o) {
        return (o.getClass().isAssignableFrom(getClass())) || (getClass().isAssignableFrom(o.getClass()));
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {}

    @Override
    public void semanticDone(SemanticAnalyzer semanticAnalyzer){}
}
