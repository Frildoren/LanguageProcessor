package analyzers.tokenizer.transitions.H;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;


public class ToI extends Transition {
    public ToI(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "[^a-zA-Z\\d_]"; //TODO: Review if this regex it's valid for --> o.c
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.CONSTANT_STRING);    // TODO: Change ¿TokenType?.
    }
}
