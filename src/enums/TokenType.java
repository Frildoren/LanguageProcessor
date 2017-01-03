package enums;

public enum TokenType {

    IDENTIFIER,
    DIVIDE_AND_ASSIGN,
    OP_LOGIC_NEGATION,
    OP_ASSIGN,
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    COMMA,
    OPEN_BRACE,
    CLOSE_BRACE,
    COLON,
    SEMICOLON,
    NEW_LINE,
    CONSTANT_INTEGER,
    CONSTANT_STRING,
    OP_ARITHMETIC_ADD,
    OP_RELATIONAL_SMALLER_THAN,

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
