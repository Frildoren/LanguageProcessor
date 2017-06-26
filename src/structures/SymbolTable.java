package structures;

import java.util.TreeMap;

public class SymbolTable extends TreeMap<String, Symbol> {

    private String name;

    public SymbolTable(String name){
        super(String.CASE_INSENSITIVE_ORDER);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
