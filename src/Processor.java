import analyzers.syntactic.SyntacticAnalyzer;
import analyzers.syntactic.SyntacticAnalyzerImpl;
import analyzers.tokenizer.Tokenizer;
import analyzers.tokenizer.TokenizerImpl;
import errors.ErrorManager;
import errors.ErrorManagerImpl;
import exceptions.PDLException;

import java.io.*;

public class Processor {

    public static void main(String[] args){

        ErrorManager errorManager = null;

        try {
            LineNumberReader reader = new LineNumberReader(new FileReader("input.txt"));
            Tokenizer tokenizer = new TokenizerImpl(reader);
            SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzerImpl(tokenizer);
            errorManager = new ErrorManagerImpl();

            syntacticAnalyzer.process();

            BufferedWriter writer = new BufferedWriter(new FileWriter("parse.txt"));
            writer.write(syntacticAnalyzer.getParse().toString());

            BufferedWriter writerTokens = new BufferedWriter(new FileWriter("tokens.txt"));
            writerTokens.write(syntacticAnalyzer.getTokens().toString());


            reader.close();
            writer.close();
            writerTokens.close();

        } catch (PDLException e) {
            errorManager.writeError(e);
            p(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void p(String e){
        System.out.println(e);
    }


}
