package analyzers.tokenizer.transitions.A;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;


public class ToB extends Transition {
    public ToB(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "=";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.DIVIDE_AND_ASSIGN);
    }
}
