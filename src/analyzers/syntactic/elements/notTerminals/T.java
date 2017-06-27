package analyzers.syntactic.elements.notTerminals;


import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class T extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // T -> int | bool | chars
        return Arrays.asList(
                Arrays.asList(new Element[] {new TokenElement(TokenType.INT){
                    @Override
                    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                        setSymbol(getTokenType());
                        T.this.semanticDone(semanticAnalyzer);
                    }
                }}),
                Arrays.asList(new Element[] {new TokenElement(TokenType.BOOL){
                    @Override
                    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                        setSymbol(getTokenType());
                        T.this.semanticDone(semanticAnalyzer);
                    }
                }}),
                Arrays.asList(new Element[] {new TokenElement(TokenType.CHARS){
                    @Override
                    public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                        setSymbol(getTokenType());
                        T.this.semanticDone(semanticAnalyzer);
                    }
                }})
        );
    }

    public int getRuleIndex() {
        return 13;
    }

}
