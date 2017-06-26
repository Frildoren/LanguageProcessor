package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class W extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //W -> = E | /= E | ( L )
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OP_ASSIGN),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                W.this.setSymbol(getSymbol());
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.DIVIDE_AND_ASSIGN),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                W.this.setSymbol(TokenType.INT);
                                semanticAnalyzer.validateSymbol(getSymbol(), TokenType.INT);
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new L(),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS)})
        );
    }

    public int getRuleIndex() {
        return 28;
    }

}
