package analyzers.semantic;

import analyzers.syntactic.elements.Element;
import enums.TokenType;
import exceptions.PDLException;
import exceptions.SemanticErrorException;
import exceptions.SymbolNotFoundException;
import structures.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemanticAnalyzerImpl implements SemanticAnalyzer {

    private SymbolTableList symbolTables;
    private List<SymbolTable> usedTables;

    public SemanticAnalyzerImpl(){
        symbolTables = new SymbolTableList();
        usedTables = new ArrayList<>();
    }

    @Override
    public void process(Element element, Token token) throws PDLException {
        element.semanticActions(this, token);
    }

    @Override
    public void addFunction(Function function){
        symbolTables.put(function.getId(), function);
        symbolTables.pushTable(function.getId());
        function.getParameters().forEach((s, symbol) -> {
            addIdentifier(new Identifier(s, symbol.getTokenType()));
        });
    }

    @Override
    public void endFunction(){
        usedTables.add(symbolTables.popTable());
    }

    @Override
    public void addIdentifier(Identifier identifier){
        symbolTables.put(identifier.getId(), identifier.getTokenType());
    }

    @Override
    public void validateIdentifier(Identifier identifier){
        TokenType tableIdentifier = ((TokenType) symbolTables.find(identifier.getId()));
        if(!identifier.getTokenType().equals(tableIdentifier)){
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
            String name = symbolTables.get(symbolTables.size()-1).getName();
            Function function = (Function) symbolTables.find(name);

            if(function.getReturnType() != symbol && (function.getReturnType() == null || !function.getReturnType().equals(symbol))){
                throw new SemanticErrorException("return type mismatch, expected " + (function.getReturnType() == null ? null : function.getReturnType()));
            }
        } catch(SymbolNotFoundException e){
            throw new SemanticErrorException("return not allowed here");
        }
    }

    @Override
    public Symbol findSymbol(String id){
        return symbolTables.find(id);
    }

    int desp = 0;

    @Override
    public String getSymbolTables(){
        StringBuilder stringBuilder = new StringBuilder();
        usedTables.add(symbolTables.popTable());

        for(int i=usedTables.size()-1; i>=0; i--){
            SymbolTable symbolTable = usedTables.get(i);
            stringBuilder.append(symbolTable.getName()).append(" # ").append(usedTables.size()-i).append(":\n");
            desp = 0;

            symbolTable.entrySet().forEach(stringSymbolEntry -> {
                stringBuilder.append("* '").append(stringSymbolEntry.getKey()).append("'").append("\n")
                        .append("+tipo: '").append(stringSymbolEntry.getValue().getTokenType()).append("'\n")
                        .append("+desplazamiento: ").append(String.valueOf(desp)).append("'\n");
                desp += 4;
            });

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
