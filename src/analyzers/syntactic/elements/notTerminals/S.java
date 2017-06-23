package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class S extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //S -> id W | return X | write ( E ) | prompt ( id )
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.IDENTIFIER),
                        new W()}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.RETURN),
                        new X()}),
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
}
