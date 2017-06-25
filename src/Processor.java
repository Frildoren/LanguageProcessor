import analyzers.syntactic.SyntacticAnalizer;
import analyzers.syntactic.SyntacticAnalyzerImpl;
import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import exceptions.PDLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

public class Processor {

    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            Tokenizer tokenizer = new TokenizerImpl(reader);
            SyntacticAnalizer syntacticAnalizer = new SyntacticAnalyzerImpl(tokenizer);

            syntacticAnalizer.process();

        } catch (PDLException e) {
            p(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void p(String e){
        System.out.println(e);
    }
}
