package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;

/**
 * Created by garri on 14/10/16.
 */
public class ToM extends Transition {
    public ToM(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "=";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.OP_ASSIGN);
    }
}
