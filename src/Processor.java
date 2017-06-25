import analyzers.syntactic.SyntacticAnalyzer;
import analyzers.syntactic.SyntacticAnalyzerImpl;
import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import exceptions.PDLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Processor {

    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            Tokenizer tokenizer = new TokenizerImpl(reader);
            SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzerImpl(tokenizer);

            syntacticAnalyzer.process();

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
