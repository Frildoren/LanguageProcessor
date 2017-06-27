package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class E extends NotTerminalElement {


    @Override
    public List<List<Element>> getBranchesClasses() {
        // E -> ! E | V R | true | false
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OP_LOGIC_NEGATION),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                semanticAnalyzer.validateSymbol(getSymbol(), TokenType.BOOL);
                                E.this.setSymbol(getSymbol());
                                E.this.semanticDone(semanticAnalyzer);
                            }
                        }
                }),
                Arrays.asList(new Element[]{
                        new V(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                E.this.setSymbol(getSymbol());
                            }
                        },
                        new R(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                if(getSymbol() != null) {
                                    E.this.setSymbol(getSymbol());
                                }
                                E.this.semanticDone(semanticAnalyzer);
                            }
                        }
                }),
                Arrays.asList(
                        new Element[]{ new TokenElement(TokenType.TRUE){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                E.this.setSymbol(TokenType.BOOL);
                                E.this.semanticDone(semanticAnalyzer);
                            }
                }
                }),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.FALSE){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                E.this.setSymbol(TokenType.BOOL);
                                E.this.semanticDone(semanticAnalyzer);
                            }
                        }
                })
        );
    }

    public int getRuleIndex() {
        return 43;
    }

}
