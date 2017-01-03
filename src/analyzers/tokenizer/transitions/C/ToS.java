package analyzers.tokenizer.transitions.C;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

public class ToS extends Transition{
    public ToS(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "\n";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        getTokenizer().toState('S');
        return null;
    }
}
