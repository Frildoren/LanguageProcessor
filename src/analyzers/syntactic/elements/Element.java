package analyzers.syntactic.elements;

import analyzers.semantic.SemanticAnalyzer;
import structures.Token;

import java.util.List;

public interface Element {
    List<Element> getFirst();
    List<Element> getFirst(List<Class<? extends Element>> done);

    void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token);

    void semanticDone(SemanticAnalyzer semanticAnalyzer);
}
