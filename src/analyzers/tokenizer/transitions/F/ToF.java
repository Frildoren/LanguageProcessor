package analyzers.tokenizer.transitions.F;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToF extends Transition {
    public ToF(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[^\"]";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().toState('F');
        getTokenizer().read();
        return null;
    }
}
