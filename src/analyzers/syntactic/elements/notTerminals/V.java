package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Function;
import structures.Symbol;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class V extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // V -> id U | ( E ) | int_const | string_const
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.IDENTIFIER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                Symbol symbol = semanticAnalyzer.findSymbol(token.getValue());
                                V.this.setSymbol(symbol.getTokenType());

                                if(symbol instanceof Function){
                                    V.this.setSymbol(symbol);
                                }
                            }
                        },
                        new U(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                if(getSymbol() != null){
                                    Function function = (Function) V.this.getSymbol();
                                    function.getParameters().putAll(((Function) getSymbol()).getParameters());
                                }
                                V.this.semanticDone(semanticAnalyzer);
                            }
                        }
                }),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                V.this.setSymbol(getSymbol());
                                V.this.semanticDone(semanticAnalyzer);
                            }
                        },
                        new TokenElement(TokenType.CLOSE_PARENTHESIS) }),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.CONSTANT_INTEGER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                V.this.setSymbol(TokenType.INT);
                                V.this.semanticDone(semanticAnalyzer);
                            }
                        }
                }),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.CONSTANT_STRING){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                V.this.setSymbol(TokenType.CHARS);
                                V.this.semanticDone(semanticAnalyzer);
                            }
                        }
                })
        );
    }

    public int getRuleIndex() {
        return 52;
    }

}
