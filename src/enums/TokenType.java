package enums;

public enum TokenType {

    UNDEFINED,

    // Arithmetics
    ADD,
    SUB,
    MULTIPLIES,
    DIVIDES,
    MODULUS,

    // Relationals
    EQUAL,
    INEQUAL,
    LESS,
    GREATER,
    LESS_EQUAL,
    GREATER_EQUAL,

    // Logical
    AND,
    OR,
    NEGATE,
    BITWISE_AND_ASSIGN,

    // Punctuation
    OPEN_BRACKET,
    CLOSE_BRACKET,
    OPEN_CURLY_BRACKET,
    CLOSE_CURLY_BRACKET,
    COMMA,
    SEMICOLON,

    // Others
    TRUE,
    FALSE,
    VAR,
    CHAR,
    BOOLEAN,
    STRING,
    INTEGER,
    END,

}
