package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Token;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class X extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //X -> E | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                X.this.setSymbol(getSymbol());
                                X.this.semanticDone(semanticAnalyzer);
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new Lambda(){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                X.this.semanticDone(semanticAnalyzer);
                            }
                        }})
        );
    }

    public int getRuleIndex() {
        return 31;
    }

}
