package analyzers;

import exceptions.PDLException;
import structures.Token;

import java.util.List;

public class Tokenizer {

    Readable readable;
    List<Token> tokens;

    public Tokenizer(Readable readable){
        this.readable = readable;
    }

    public void process() throws PDLException {
        //ToFo: Medium
    }

    public List<Token> getTokens(){
        return tokens;
    }
}
