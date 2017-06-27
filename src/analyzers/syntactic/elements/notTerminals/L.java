package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Symbol;
import structures.Token;

import java.util.*;

public class L extends NotTerminalElement {

    Map<String, Symbol> parameters = new LinkedHashMap<>();


    @Override
    public List<List<Element>> getBranchesClasses() {
        //L -> E Q | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new E(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                parameters.put(String.valueOf(new Random().nextLong()), getSymbol());
                            }
                        },
                        new Q(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                L.this.parameters.putAll(parameters);
                                L.this.semanticDone(semanticAnalyzer);
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new Lambda(){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                L.this.semanticDone(semanticAnalyzer);
                            }
                        }})
        );
    }

    public int getRuleIndex() {
        return 33;
    }

}
