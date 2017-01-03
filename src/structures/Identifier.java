package structures;

import enums.TokenType;
import enums.VariableType;

public class Identifier implements Symbol {

    VariableType type;

    public Identifier(VariableType type){
        this.type = type;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public TokenType getTokenType() {
        return TokenType.IDENTIFIER;
    }
}

