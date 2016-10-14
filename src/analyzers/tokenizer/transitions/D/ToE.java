package analyzers.tokenizer.transitions.D;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;

public class ToE extends Transition {

    public ToE(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "\\D";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.CONSTANT_INTEGER);
    }
}
