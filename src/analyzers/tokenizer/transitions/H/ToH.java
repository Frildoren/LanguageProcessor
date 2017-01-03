package analyzers.tokenizer.transitions.H;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import structures.Token;


public class ToH extends Transition {
    public ToH(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[a-zA-Z\\d_]";
        // a-z (ASCII 97 and 122) && A-Z(ASCII 65 and 90) && \d digit [0-9] && _ [Literally _]

    }

    @Override
    public Token semanticRules() {
        getTokenizer().lexemeAppend(getTokenizer().getCurrentChar());
        getTokenizer().toState('H');
        getTokenizer().read();
        return null;
    }
}
