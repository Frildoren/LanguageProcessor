package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Symbol;
import structures.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class K extends NotTerminalElement {

    Map<String, Symbol> parameters = new HashMap<>();

    @Override
    public List<List<Element>> getBranchesClasses() {
        // K -> , T id K | lambda
        return Arrays.asList(
                Arrays.asList(
                        new TokenElement(TokenType.COMMA),
                        new T(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                K.this.setSymbol(getSymbol());
                            }
                        },
                        new TokenElement(TokenType.IDENTIFIER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                parameters.put(token.getValue(), K.this.getSymbol());
                            }
                        },
                        new K(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                parameters.putAll(parameters);
                                K.this.semanticDone(semanticAnalyzer);
                            }
                        }
                ),
                Arrays.asList(new Element[]{new Lambda(){
                    @Override
                    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                        K.this.semanticDone(semanticAnalyzer);
                    }
                }})
        );
    }

    public int getRuleIndex() {
        return 18;
    }

}
