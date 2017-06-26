package analyzers.semantic;

import analyzers.syntactic.elements.Element;
import exceptions.PDLException;
import exceptions.SemanticErrorException;
import exceptions.SymbolNotFoundException;
import structures.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SemanticAnalyzerImpl implements SemanticAnalyzer {

    private SymbolTableList symbolTables;

    public SemanticAnalyzerImpl(){
        symbolTables = new SymbolTableList();
    }

    @Override
    public void process(Element element, Token token) throws PDLException {
        element.semanticActions(this, token);
    }

    @Override
    public void addFunction(Function function){
        addIdentifier(function);
        symbolTables.pushTable(function.getId());
        function.getParameters().forEach((s, symbol) -> {
            addIdentifier(new Identifier(s, symbol.getTokenType()));
        });
    }

    @Override
    public void endFunction(){
        symbolTables.popTable();
    }

    @Override
    public void addIdentifier(Identifier identifier){
        symbolTables.put(identifier.getId(), identifier.getTokenType());
    }

    @Override
    public void validateIdentifier(Identifier identifier){
        Identifier tableIdentifier = ((Identifier) symbolTables.find(identifier.getId()));
        if(!identifier.getType().equals(tableIdentifier.getType())){
            throw new SemanticErrorException(identifier.getId() + " was declared with type " + tableIdentifier.getTokenType());
        }
    }

    @Override
    public void validateFunction(Function function){
        try {
            Function expectedFunction = (Function) symbolTables.find(function.getId());
            if(function.getParameters().size() != expectedFunction.getParameters().size()){
                throw new SemanticErrorException("wrong number of parameters");
            }
            for(int i=0; i<function.getParameters().size(); i++){
                Symbol symbol = new ArrayList<>(function.getParameters().values()).get(i);
                Symbol expectedSymbol = new ArrayList<>(expectedFunction.getParameters().values()).get(i);
                if(!symbol.getTokenType().equals(expectedSymbol.getTokenType())){
                    throw new SemanticErrorException("parameter " + (i+1) + " expected to be " + expectedSymbol.getTokenType());
                }
            }

        } catch(ClassCastException e){
            throw new SemanticErrorException(function.getId() + " is not a function");
        }
    }

    @Override
    public void validateSymbol(Symbol symbol, Symbol expectedSymbol){
        if(!expectedSymbol.equals(symbol)){
            throw new SemanticErrorException("expected type " + expectedSymbol.getTokenType());
        }
    }

    @Override
    public void validateReturn(Symbol symbol){
        try {
            String name = symbolTables.get(symbolTables.size()).getName();
            Function function = (Function) symbolTables.find(name);

            if(!function.getReturnType().equals(symbol)){
                throw new SemanticErrorException("return type mismatch, expected " + symbol.getTokenType());
            }
        } catch(SymbolNotFoundException e){
            throw new SemanticErrorException("return not allowed here");
        }
    }

}
