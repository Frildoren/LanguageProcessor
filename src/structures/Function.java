package structures;

import enums.TokenType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Function extends Identifier {

    Symbol returnType;
    Map<String, Symbol> parameters = new LinkedHashMap<>();

    public Function(String id, Symbol returnType){
            super(id, TokenType.FUNCTION);
            this.returnType = returnType;
    }

    public Symbol getReturnType() {
        return returnType;
    }

    public void setReturnType(Symbol returnType) {
        this.returnType = returnType;
    }

    public Map<String, Symbol> getParameters() {
        return parameters;
    }
}

