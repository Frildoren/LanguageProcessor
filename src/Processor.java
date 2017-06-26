import analyzers.semantic.SemanticAnalyzer;
import analyzers.semantic.SemanticAnalyzerImpl;
import analyzers.syntactic.SyntacticAnalyzer;
import analyzers.syntactic.SyntacticAnalyzerImpl;
import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import exceptions.PDLException;

import java.io.*;

public class Processor {

    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            Tokenizer tokenizer = new TokenizerImpl(reader);
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzerImpl();
            SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzerImpl(tokenizer, semanticAnalyzer);

            syntacticAnalyzer.process();

            BufferedWriter writer = new BufferedWriter(new FileWriter("parse.txt"));
            writer.write(syntacticAnalyzer.getParse().toString());

            BufferedWriter writerTokens = new BufferedWriter(new FileWriter("tokens.txt"));
            writerTokens.write(syntacticAnalyzer.getTokens().toString());


            reader.close();
            writer.close();
            writerTokens.close();

        } catch (PDLException e) {
            p(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void p(String e){
        System.out.println(e);
    }
}
