package exceptions;


public class ConstantIntegerException extends PDLException {
    public ConstantIntegerException() {
        super("Integer out of bound (max 32767)");
    }
}
