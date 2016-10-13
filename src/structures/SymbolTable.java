package structures;

import java.util.TreeMap;

public class SymbolTable extends TreeMap<String, Symbol> {

    public SymbolTable(){
        super(String.CASE_INSENSITIVE_ORDER);
    }

}
