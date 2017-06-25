package analyzers.syntactic;

public interface SyntacticAnalyzer {
    void process();

    StringBuilder getParse();
}
