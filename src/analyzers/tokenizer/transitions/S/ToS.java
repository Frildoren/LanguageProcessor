package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToS extends Transition {

    public ToS(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[^\\S]";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().toState('S');
        getTokenizer().read();
        return null;
    }
}
