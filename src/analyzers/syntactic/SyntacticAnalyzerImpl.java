package analyzers.syntactic;

import analyzers.tokenizer.Tokenizer;

public class SyntacticAnalyzerImpl implements SyntacticAnalizer {

    /*
    P -> F Z P | B Z P | Z P
    Z -> eol Y
    Y -> eol | lambda
    F -> function H id ( A ) Z { Z C }
    H -> T | lambda
    T -> int | bool | chars
    A -> T id K | lambda
    K -> , T id K | lambda

    B -> var T id | if ( E ) S | switch ( E ) | { Z I Z } | S
    S -> id W | return X | write ( E ) | prompt ( id )
    W -> = E | /= E | ( L )
    X -> E | lambda
    L -> E Q | lambda
    Q -> , E Q | lambda
    I -> case int_const : J | lambda
    J -> Z J | B Z J | break Z J | I
    E -> ! E | V R
    R -> + E | < E | lambda
    C -> B Z C | lambda
    V -> id U | ( E ) | int_const | string_const
    U -> ( L ) | lambda
     */

    private Tokenizer tokenizer;

    public SyntacticAnalyzerImpl(Tokenizer tokenizer){
        this.tokenizer = tokenizer;
    }

    @Override
    public void process(){
        
    }

}
