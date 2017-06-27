package structures;

import enums.TokenType;

public class Identifier implements Symbol {

    Symbol type;
    String id;

    public Identifier(String id, TokenType type){
        this.type = type;
        this.id = id;
    }

    public Symbol getType() {
        return type;
    }

    public void setType(Symbol type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TokenType getTokenType() {
        return (TokenType) getType();
    }
}

