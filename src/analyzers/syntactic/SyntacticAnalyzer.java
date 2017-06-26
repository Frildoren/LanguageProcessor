package analyzers.syntactic;

public interface SyntacticAnalyzer {
    void process();

    StringBuilder getTokens();
    StringBuilder getParse();
}
