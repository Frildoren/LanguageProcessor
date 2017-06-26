package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Function;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class F extends NotTerminalElement {
    public List<List<Element>> getBranchesClasses() {
        // F -> function H id ( A ) Z { Z C }
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.FUNCTION),
                        new H(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                F.this.setSymbol(getSymbol());
                            }
                        },
                        new TokenElement(TokenType.IDENTIFIER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                F.this.setSymbol(new Function(token.getValue(), F.this.getSymbol()));
                            }
                        },
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new A(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                ((Function) F.this.getSymbol()).getParameters().putAll(parameters);
                            }
                        },
                        new TokenElement(TokenType.CLOSE_PARENTHESIS),
                        new Z(),
                        new TokenElement(TokenType.OPEN_BRACE){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                semanticAnalyzer.addFunction(((Function) F.this.getSymbol()));
                            }
                        },
                        new Z(),
                        new C(),
                        new TokenElement(TokenType.CLOSE_BRACE){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                semanticAnalyzer.endFunction();
                            }
                        }
                })
        );
    }

    public int getRuleIndex() {
        return 10;
    }
}
