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

public class R extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // R -> + E | < E | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OP_ARITHMETIC_ADD),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                semanticAnalyzer.validateSymbol(getSymbol(), TokenType.INT);
                                R.this.setSymbol(TokenType.INT);
                                R.this.semanticDone(semanticAnalyzer);
                            }
                        } }),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OP_RELATIONAL_SMALLER_THAN),
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                semanticAnalyzer.validateSymbol(getSymbol(), TokenType.INT);
                                R.this.setSymbol(TokenType.BOOL);
                                R.this.semanticDone(semanticAnalyzer);
                            }
                        } }),
                Arrays.asList(new Element[]{
                        new Lambda(){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                R.this.semanticDone(semanticAnalyzer);
                            }
                        }
                })
        );
    }
    public int getRuleIndex() {
        return 47;
    }

}
