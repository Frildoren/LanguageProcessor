package analyzers.tokenizer.transitions.D;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToD extends Transition {

    public ToD(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "\\d";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().lexemeAppend(getTokenizer().getCurrentChar());
        getTokenizer().toState('D');
        getTokenizer().read();
        return null;
    }
}
