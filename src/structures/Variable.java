package structures;

import enums.VariableType;

public class Variable {

    VariableType type;
    VariableType returnType;

    Variable(VariableType type) {
        this(type, false);
    }

    Variable(VariableType type, boolean isFunction){
        if(isFunction){
            this.type = VariableType.FUNCTION;
            this.returnType = type;
        } else {
            this.type = type;
        }
    }

}

