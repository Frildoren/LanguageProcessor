import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import exceptions.PDLException;

import java.io.BufferedReader;
import java.io.StringReader;

public class Processor {

    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new StringReader("84"));
            Tokenizer tokenizer = new TokenizerImpl(reader);

            while(true) {
                p(tokenizer.readToken().toString());
            }

        } catch (PDLException e) {
            p(e.getMessage());
        }

    }

    static void p(String e){
        System.out.println(e);
    }
}
