package analyzers.syntactic.elements.notTerminals;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;
import structures.Function;
import structures.Identifier;
import structures.Token;

import java.util.Arrays;
import java.util.List;

public class S extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //S -> id W | return X | write ( E ) | prompt ( id )
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.IDENTIFIER){
                            @Override
                            public void semanticActions(SemanticAnalyzer semanticAnalyzer, Token token) {
                                S.this.setSymbol(new Identifier(token.getValue(), null));
                            }
                        },
                        new W(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                Identifier identifier = (Identifier) S.this.getSymbol();
                                if(getSymbol() instanceof Function){
                                    Function function = (Function) getSymbol();
                                    function.setId(identifier.getId());
                                    semanticAnalyzer.validateFunction(function);
                                } else {
                                    identifier.setType(getSymbol());
                                    semanticAnalyzer.validateIdentifier(identifier);
                                }
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.RETURN),
                        new X(){
                            @Override
                            public void semanticDone(SemanticAnalyzer semanticAnalyzer) {
                                semanticAnalyzer.validateReturn(getSymbol());
                            }
                        }}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.WRITE),
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new E(),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS)}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.PROMPT),
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new TokenElement(TokenType.IDENTIFIER),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS)})
        );
    }

    public int getRuleIndex() {
        return 24;
    }

}
