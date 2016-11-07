package analyzers.tokenizer.transitions.S;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import structures.Token;


public class ToK extends Transition {
    public ToK(TokenizerImpl tokenizer) {
        super(tokenizer);
    }

    @Override
    public String inputRule() {
        return "<";
    }

    @Override
    public Token semanticRules() {
        getTokenizer().read();
        return new Token((TokenType.OP_RELATIONAL_SMALLER_THAN));
    }
}
