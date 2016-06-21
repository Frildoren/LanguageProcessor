import analyzers.SemanticAnalyzer;
import analyzers.Tokenizer;
import exceptions.PDLException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Processor {

    public static void main(String[] args){

        try {

            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            Tokenizer tokenizer = new Tokenizer(br);
            tokenizer.process();

            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer(tokenizer.getTokens());
            semanticAnalyzer.process();

        } catch(IOException e){
            p(e.getMessage());
        } catch (PDLException e) {
            p(e.getMessage());
        }

    }

    static void p(String e){
        System.out.println(e);
    }
}
