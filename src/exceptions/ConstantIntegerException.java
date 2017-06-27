package exceptions;


public class ConstantIntegerException extends PDLException {
    public ConstantIntegerException(int errorLine) {
        super("Integer out of bound (max 32767)", errorLine);
    }
}
