package analyzers.tokenizer;

import analyzers.tokenizer.transitions.Transition;
import exceptions.EndOfInputException;
import exceptions.PDLException;
import structures.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class TokenizerImpl implements Tokenizer {

    private BufferedReader in;

    private char currentChar;
    private char currentState;

    public TokenizerImpl(BufferedReader in) {
        this.in = in;
        currentState = 'S';
        read();
    }

    public void read() throws EndOfInputException{
        try {
            currentChar = (char) in.read();
        } catch (IOException e) {
            throw new PDLException(e);
        }
    }

    public void toState(char newState){
        currentState = newState;
    }

    public Token readToken(){

        Token token = null;
        while(token == null){
            if(currentChar < 0 || currentChar == 65535){
                throw new EndOfInputException();
            }

            List<Transition> transitions = Transition.getTransitions(currentState, this);
            for(Transition t : transitions){
                if(t.isValid()){
                    token = t.semanticRules();
                    break;
                }
            }
        }

        return token;

    }

    public char getCurrentChar(){
        return currentChar;
    }

}
