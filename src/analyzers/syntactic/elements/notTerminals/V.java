package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class V extends NotTerminalElement {

    @Override
    public List<List<Element>> getBranchesClasses() {
        // V -> id U | ( E ) | int_const | string_const
        return Arrays.asList(
                Arrays.asList(new Element[]{ new TokenElement(TokenType.IDENTIFIER), new U() }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.OPEN_PARENTHESIS), new E(), new TokenElement(TokenType.CLOSE_PARENTHESIS) }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.CONSTANT_INTEGER) }),
                Arrays.asList(new Element[]{ new TokenElement(TokenType.CONSTANT_STRING) })
        );
    }

    public int getRuleIndex() {
        return 49;
    }

}
