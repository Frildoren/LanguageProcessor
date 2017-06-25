package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class I extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //I -> case int_const : J | lambda
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.CASE),
                        new TokenElement(TokenType.CONSTANT_INTEGER),
                        new TokenElement(TokenType.COLON),
                        new J()}),
                Arrays.asList(new Element[]{
                        new Lambda()})
        );
    }

    public int getRuleIndex() {
        return 36;
    }

}
