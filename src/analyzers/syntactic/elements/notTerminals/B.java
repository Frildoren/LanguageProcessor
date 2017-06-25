package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class B extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //B -> var T id | if ( E ) S | switch ( E ) | { Z I Z } | S
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.VAR),
                        new T(),
                        new TokenElement(TokenType.IDENTIFIER)}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.IF),
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new E(),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS),
                        new S()}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.SWITCH),
                        new TokenElement(TokenType.OPEN_PARENTHESIS),
                        new E(),
                        new TokenElement(TokenType.CLOSE_PARENTHESIS),
                        new TokenElement(TokenType.OPEN_BRACE),
                        new Z(),
                        new I(),
                        new TokenElement(TokenType.CLOSE_BRACE)}),
                Arrays.asList(new Element[]{
                        new S()})
        );
    }

    public int getRuleIndex() {
        return 9;
    }

}
