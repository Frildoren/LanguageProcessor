package enums;

import java.util.EnumSet;

public enum TokenType {

    IDENTIFIER,
    DIVIDE_AND_ASSIGN,
    OP_LOGIC_NEGATION,
    OP_ASSIGN,
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    OPEN_BRACE,
    CLOSE_BRACE,
    COLON,
    NEW_LINE,
    CONSTANT_INTEGER,
    CONSTANT_STRING,
    OP_ARITHMETIC_ADD,
    OP_RELATIONAL_SMALLER_THAN,
    COMMA,
    SEMICOLON,

    //Reserved words
    VAR,
    TRUE,
    FALSE,
    WRITE,
    PROMPT,
    INT,
    CHARS,
    BOOL,
    IF,
    ELSE,
    RETURN;

    public static final EnumSet<TokenType> RESERVED_WORDS = EnumSet.of(VAR, TRUE, FALSE, WRITE, PROMPT, INT, CHARS, BOOL, IF, ELSE, RETURN);

}
