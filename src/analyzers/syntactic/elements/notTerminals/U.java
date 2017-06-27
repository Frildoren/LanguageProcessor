package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Function;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class U extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // U -> ( L ) | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new L(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                Function function = new Function(null, null);
                                function.getParameters().putAll(parameters);
                                U.this.semanticDone(semanticAnalyzer);
                            }
                        },
                        new TokenElement(TokenType.CLOSE_PARENTHESIS)
                }),
                Arrays.asList(new Element[]{
                        new Lambda(){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                U.this.semanticDone(semanticAnalyzer);
                            }
                        }
                })
        );
    }

    public int getRuleIndex() {
        return 56;
    }

}
