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
        return "[^a-zA-Z\\d_]";
    }

    @Override
    public Token semanticRules() {
        TokenType reservedWord = getReservedWord(getTokenizer().getLexeme());
        if(reservedWord != null){
            return new Token(reservedWord, null);
        } else {
            return new Token(TokenType.IDENTIFIER, getTokenizer().getLexeme());
        }
    }

    private TokenType getReservedWord(String lexeme){
        for (TokenType reservedWord : TokenType.RESERVED_WORDS) {
            if(reservedWord.name().toLowerCase().equals(lexeme))
                return reservedWord;
        }

        return null;
    }
}
