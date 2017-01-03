package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToA extends Transition {

    public ToA(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "/";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().toState('A');
        getTokenizer().read();
        return null;
    }
}
