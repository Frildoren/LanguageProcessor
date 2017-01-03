package analyzers.tokenizer.transitions.D;

import analyzers.tokenizer.TokenizerImpl;
import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import exceptions.ConstantIntegerException;
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
        if (Integer.parseInt(getTokenizer().getLexeme()) > 1<<15){
            throw new ConstantIntegerException();
        }

        return new Token(TokenType.CONSTANT_INTEGER, getTokenizer().getLexeme());
    }
}
