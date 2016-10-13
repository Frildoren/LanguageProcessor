package analyzers.tokenizer.transitions.C;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToC extends Transition {
    public ToC(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[^\n]";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return null;
    }
}
