package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Function;

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
                                W.this.semanticDone(semanticAnalyzer);
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new L(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                Function function = new Function(null, null);
                                function.getParameters().putAll(parameters);
                                W.this.setSymbol(function);
                                W.this.semanticDone(semanticAnalyzer);
                            }
                        },
                        new TokenElement(TokenType.CLOSE_PARENTHESIS)})
        );
    }

    public int getRuleIndex() {
        return 28;
    }

}
