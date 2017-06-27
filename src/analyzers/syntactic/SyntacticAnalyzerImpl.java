package analyzers.syntactic;

import analyzers.semantic.SemanticAnalyzer;
import analyzers.syntactic.elements.Element;
import analyzers.syntactic.elements.NotTerminalElement;
import analyzers.syntactic.elements.notTerminals.P;
import analyzers.syntactic.elements.terminals.Lambda;
import analyzers.syntactic.elements.terminals.TokenElement;
import analyzers.tokenizer.Tokenizer;
import enums.TokenType;
import exceptions.EndOfInputException;
import exceptions.SyntaxErrorException;
import structures.Token;

import java.io.LineNumberReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class SyntacticAnalyzerImpl implements SyntacticAnalyzer {

    /*
    P -> F P | B P | Z P | eol
    Z -> eol Y | ; Y
    Y -> eol Y | ; Y | lambda
    F -> function H id ( A ) Z { Z C }
    H -> T | lambda
    T -> int | bool | chars
    A -> T id K | lambda
    K -> , T id K | lambda

    B -> var T id | if ( E ) S | switch ( E ) { Z I } | S
    S -> id W | return X | write ( E ) | prompt ( id )
    W -> = E | /= E | W
    X -> E | lambda
    L -> E Q | lambda
    Q -> , E Q | lambda
    I -> case int_const : J | lambda
    J -> B Z J | break Z J | Z J | I
    E -> ! E | V R | true | false
    R -> + E | < E | lambda
    C -> B Z C | lambda
    V -> id U | ( E ) | int_const | string_const
    U -> ( L ) | lambda
     */

    private Tokenizer tokenizer;
    private SemanticAnalyzer semanticAnalyzer;

    private Stack<Element> stack = new Stack<>();
    private StringBuilder parse = new StringBuilder();
    private StringBuilder tokens = new StringBuilder();

    public SyntacticAnalyzerImpl(Tokenizer tokenizer, SemanticAnalyzer semanticAnalyzer) {
        this.tokenizer = tokenizer;
        this.semanticAnalyzer = semanticAnalyzer;

        stack.add(new P());
        parse.append("D");
    }

    @Override
    public void process(){
        Token token;
        try {
            while ((token = tokenizer.readToken()) != null) {
                System.out.println(token.getType());
                processToken(token);
                tokens.append(token.toString()).append((char) Character.LINE_SEPARATOR);
            }
        } catch(EndOfInputException e){}
    }

    private void processToken(Token token){

        if(stack.empty() && token.getType().equals(TokenType.EOF))
            throw new EndOfInputException(tokenizer.getIn().getLineNumber());

        try {
            Element head;
            while ((head = stack.pop()) instanceof NotTerminalElement) {
                NotTerminalElement notTerminal = (NotTerminalElement) head;
                List<Element> first = notTerminal.getFirst();

                int i = -1;
                for(int j=0; j<notTerminal.getBranchesClasses().size(); j++){
                    if(notTerminal.getBranchFirsts().get(j).contains(new TokenElement(token.getType())) || notTerminal.getBranchFirsts().get(j).contains(new Lambda())) {
                        i = j;
                        break;
                    }
                }

                if(i == -1){
                    if(!first.contains(new Lambda())){
                        throw new SyntaxErrorException(token.getType().toString(), first.toString(), tokenizer.getIn().getLineNumber());
                    }
                } else {
                    parse.append(" ").append(notTerminal.getRuleIndex() + i);

                    List<Element> elementsList = notTerminal.getBranchesClasses().get(i);
                    for (int j = elementsList.size() - 1; j >= 0; j--) {
                        stack.push(elementsList.get(j));
                    }
                }
            }

            head.semanticActions(semanticAnalyzer, token);

            if(head instanceof Lambda){
                processToken(token);

            } else if(!((TokenElement) head).getTokenType().equals(token.getType())){
                throw new SyntaxErrorException(token.getType().toString(), head.toString(), tokenizer.getIn().getLineNumber());
            }

        } catch (NoSuchElementException e){
            throw new SyntaxErrorException(token.getType().toString(), tokenizer.getIn().getLineNumber());
        }

    }

    @Override
    public StringBuilder getParse() {
        return parse;
    }

    @Override
    public StringBuilder getTokens() {
        return tokens;
    }

}
