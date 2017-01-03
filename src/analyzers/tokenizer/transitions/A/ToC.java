package analyzers.tokenizer.transitions.A;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;

/**
 * Created by frildoren on 13/10/16.
 */
public class ToC extends Transition {
    public ToC(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "/";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().toState('C');
        getTokenizer().read();
        return null;
    }
}
