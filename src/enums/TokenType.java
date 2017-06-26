package enums;

import structures.Symbol;

import java.util.EnumSet;

public enum TokenType implements Symbol {

    IDENTIFIER("identifier"),
    DIVIDE_AND_ASSIGN("divideAndAssign"),
    OP_LOGIC_NEGATION("opLogicNegation"),
    OP_ASSIGN("opAssign"),
    OPEN_PARENTHESIS("openParenthesis"),
    CLOSE_PARENTHESIS("closeParenthesis"),
    OPEN_BRACE("openBrace"),
    CLOSE_BRACE("closeBrace"),
    COLON("colon"),
    NEW_LINE("newLine"),
    CONSTANT_INTEGER("constantInteger"),
    CONSTANT_STRING("constantString"),
    OP_ARITHMETIC_ADD("opArithmeticAdd"),
    OP_RELATIONAL_SMALLER_THAN("opRelationalSmallerThan"),
    COMMA("comma"),
    SEMICOLON("semicolon"),

    //Reserved words
    VAR("var"),
    TRUE("true"),
    FALSE("false"),
    WRITE("write"),
    PROMPT("prompt"),
    INT("int"),
    CHARS("chars"),
    BOOL("bool"),
    IF("if"),
    ELSE("else"),
    RETURN("return"),
    BREAK("break"),
    CASE("case"),
    SWITCH("switch"),
    FUNCTION("function"),
    EOF("eof");

    private String name;

    TokenType(String name) {
        this.name = name;
    }

    @Override
    public TokenType getTokenType() {
        return this;
    }

    public static final EnumSet<TokenType> RESERVED_WORDS = EnumSet.of(VAR, TRUE, FALSE, WRITE, PROMPT, INT, CHARS, BOOL, IF, ELSE, RETURN, BREAK,
            CASE, SWITCH, FUNCTION);

    public String toString() {
        return name;
    }

}
