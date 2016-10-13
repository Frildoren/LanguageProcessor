import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import exceptions.PDLException;

import java.io.BufferedReader;
import java.io.StringReader;

public class Processor {

    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new StringReader("//polla\n/="));
            Tokenizer tokenizer = new TokenizerImpl(reader);

            tokenizer.readToken();

        } catch (PDLException e) {
            p(e.getMessage());
        }

    }

    static void p(String e){
        System.out.println(e);
    }
}
