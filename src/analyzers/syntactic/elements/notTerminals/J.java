package analyzers.syntactic.elements.notTerminals;

import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.terminals.TokenElement;
import enums.TokenType;

import java.util.Arrays;
import java.util.List;

public class J extends NotTerminalElement {
    @Override
    public List<List<Element>> getBranchesClasses() {
        //J -> Z J | B Z J | break Z J | I
        return Arrays.asList(
                Arrays.asList(new Element[]{
                        new B(),
                        new Z(),
                        new J()}),
                Arrays.asList(new Element[]{
                        new TokenElement(TokenType.BREAK),
                        new Z(),
                        new J()}),
                Arrays.asList(new Element[]{
                        new Z(),
                        new J()}),
                Arrays.asList(new Element[]{
                        new I()})
        );
    }

    public int getRuleIndex() {
        return 38;
    }

}
