package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;


public class ToH extends Transition {
    public ToH(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[a-zA-Z]"; // Letters (both uppercase and lowercase letters)
    }

    @Override
    public Token semanticRules() {
        getTokenizer().toState('H');
        getTokenizer().read();
        return null;
    }
}
