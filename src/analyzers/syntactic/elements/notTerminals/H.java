package analyzers.syntactic.elements.notTerminals;


import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class H extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // H -> T | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{new T(){
                    @Override
                    public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                        H.this.setSymbol(getSymbol());
                        H.this.semanticDone(semanticAnalyzer);
                    }
                }}),
                Arrays.asList(new Element[]{new Lambda(){
                    @Override
                    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                        H.this.semanticDone(semanticAnalyzer);
                    }
                }})
        );
    }

    public int getRuleIndex() {
        return 11;
    }

}
