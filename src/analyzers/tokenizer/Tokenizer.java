package analyzers.tokenizer;

import structures.Token;

import java.io.BufferedReader;
import java.io.LineNumberReader;

public interface Tokenizer {
    Token readToken();

    LineNumberReader getIn();
}
