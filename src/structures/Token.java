package structures;

import enums.TokenType;

public class Token {

    TokenType type;
    String value;

    public Token(TokenType type){
        this(type, null);
    }

    public Token(TokenType type, String value){
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + type.name() + ", " + value + '>';
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
