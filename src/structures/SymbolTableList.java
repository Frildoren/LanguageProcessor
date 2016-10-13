package structures;

import exceptions.SymbolNotFoundException;

import java.util.ArrayList;

public class SymbolTableList extends ArrayList<SymbolTable> {

    public SymbolTableList(){
        SymbolTable reservedWords = new SymbolTable();
        add(reservedWords);
    }

    public Symbol find(String index) throws SymbolNotFoundException {
        for(int i=size()-1; i>=0; i--){
            SymbolTable symbolTable = get(i);
            Symbol s = symbolTable.get(index);

            if(s != null){
                return s;
            }
        }

        throw new SymbolNotFoundException();
    }

    public Symbol find(Token token) throws SymbolNotFoundException {
        return find(token.getValue());
    }

    public void put(String index, Symbol symbol){
        get(size()-1).put(index, symbol);
    }

    public void pushTable(){
        add(new SymbolTable());
    }

    public void popTable(){
        remove(size()-1);
    }

}
