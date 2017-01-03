package structures;

import enums.VariableType;

public class Function extends Identifier {

    VariableType returnType;

    public Function(VariableType returnType){
            super(VariableType.FUNCTION);
            this.returnType = returnType;
    }

    public VariableType getReturnType() {
        return returnType;
    }

    public void setReturnType(VariableType returnType) {
        this.returnType = returnType;
    }

}

