package structures;

import enums.VariableType;

public class Variable {

    VariableType type;
    VariableType returnType;

    public Variable(VariableType type) {
        this(type, false);
    }

    public Variable(VariableType type, boolean isFunction){
        if(isFunction){
            this.type = VariableType.FUNCTION;
            this.returnType = type;
        } else {
            this.type = type;
        }
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public VariableType getReturnType() {
        return returnType;
    }

    public void setReturnType(VariableType returnType) {
        this.returnType = returnType;
    }
}

