package analyzers.semantic;

import analyzers.syntactic.elements.Element;
import structures.Function;
import structures.Identifier;
import structures.Symbol;
import structures.Token;

public interface SemanticAnalyzer {

    void process(Element element, Token token);

    void addFunction(Function function);

    void endFunction();

    void addIdentifier(Identifier identifier);

    void validateIdentifier(Identifier identifier);

    void validateFunction(Function function);

    void validateSymbol(Symbol symbol, Symbol expectedSymbol);

    void validateReturn(Symbol symbol);

    Symbol findSymbol(String id);

    String getSymbolTables();
}
