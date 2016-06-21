package structures;

import java.util.HashMap;

public class SymbolTable extends HashMap<String, Variable> {

    String name;

    public SymbolTable(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
