package analyzers;

import enums.TokenType;
import exceptions.PDLException;
import structures.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Tokenizer extends BufferedReader {

    List<Token> tokens;

    public Tokenizer(Reader in) {
        super(in);
    }

    public void process() throws PDLException, IOException {
        //ToFo: Medium

        String state = "";
        int value = -1, lineCounter = 1;
        TokenType tokenType = TokenType.UNDEFINED;

        while((value = read()) != -1) {

            char valueChar =  (char) value;


        }

    }

    public List<Token> getTokens(){
        return tokens;
    }
}
