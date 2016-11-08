package analyzers.tokenizer.transitions.F;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;

public class ToG extends Transition {
    public ToG(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "\"";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.CONSTANT_STRING, getTokenizer().getLexeme());
    }
}
