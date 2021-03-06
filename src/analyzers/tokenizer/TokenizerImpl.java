package analyzers.tokenizer;

import analyzers.tokenizer.transitions.Transition;
import enums.TokenType;
import exceptions.EndOfInputException;
import exceptions.PDLException;
import exceptions.UnexpectedInputException;
import structures.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;

public class TokenizerImpl implements Tokenizer {

    private LineNumberReader in;

    private char currentChar;
    private char currentState;
    private String lexeme;

    public TokenizerImpl(LineNumberReader in) {
        this.in = in;
        resetState();
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

    private void resetState(){
        toState('S');
        lexeme = "";
    }

    public Token readToken(){

        Token token = null;
        while(token == null){
            boolean anyValid = false;

            List<Transition> transitions = Transition.getTransitions(currentState, this);
            for(Transition t : transitions){
                if(t.isValid()){
                    anyValid = true;
                    token = t.semanticRules();
                    break;
                }
            }

            if(!anyValid){
                if(currentChar < 0 || currentChar == Character.MAX_VALUE) {
                    return new Token(TokenType.EOF);
                }

                throw new UnexpectedInputException(String.format("Unexpected character: '%c'", currentChar), getIn().getLineNumber());
            }

        }

        resetState();
        return token;

    }

    public char getCurrentChar(){
        return currentChar;
    }

    public void lexemeAppend(char c){
        lexeme += c;
    }

    public String getLexeme() {
        return lexeme;
    }

    @Override
    public LineNumberReader getIn() { return in; }

}
