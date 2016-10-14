package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;

/**
 * Created by garri on 14/10/16.
 */
public class ToV extends Transition {
    public ToV(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() { return "\n";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token(TokenType.NEW_LINE);
    }
}
