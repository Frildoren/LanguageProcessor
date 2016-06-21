package structures;

import enums.VariableType;
import exceptions.PDLException;
import exceptions.VariableNotFoundException;

import java.util.ArrayList;

public class SymbolTableList extends ArrayList<SymbolTable> {

    public SymbolTable last(){
        return get(size()-1);
    }

    public SymbolTable findByToken(Token token) throws PDLException {
        //ToDo: Easy
        return null;
    }

    public VariableType findVariableType(Token token) throws PDLException {
        SymbolTable st = findByToken(token);
        Variable v = st.get(token.getValue());

        if(v == null)
            throw new VariableNotFoundException();

        return v.getType();
    }

}
