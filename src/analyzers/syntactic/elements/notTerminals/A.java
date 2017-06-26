package analyzers.syntactic.elements.notTerminals;


import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import javafx.util.Pair;
import structures.Symbol;
import structures.Token;

import java.util.*;

public class A extends NotTerminalElement {

    Map<String, Symbol> parameters = new HashMap<>();

    @Override
    public List<List<Element>> getBranchesClasses() {
        // A -> T id K | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new T(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                A.this.setSymbol(getSymbol());
                            }
                        },
                        new TokenElement(TokenType.IDENTIFIER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                parameters.put(token.getValue(), A.this.getSymbol());
                            }
                        },
                        new K(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                parameters.putAll(parameters);
                                A.this.semanticDone(semanticAnalyzer);
                            }
                        }
                }),
                Arrays.asList(new Element[]{new Lambda()})
        );
    }

    public int getRuleIndex() {
        return 16;
    }

}
