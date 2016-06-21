package analyzers;

import exceptions.PDLException;
import structures.Token;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

public class Tokenizer extends BufferedReader {

    List<Token> tokens;

    public Tokenizer(Reader in) {
        super(in);
    }

    public void process() throws PDLException {
        //ToFo: Medium
    }

    public List<Token> getTokens(){
        return tokens;
    }
}
