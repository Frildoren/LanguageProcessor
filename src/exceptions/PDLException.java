package exceptions;

public class PDLException extends RuntimeException {

    private int errorLine;

    public PDLException(String error) {
        super(error);
    }

    public PDLException(String error, int errorLine){
        super(error);
        this.errorLine = errorLine;
    }

    public PDLException(Exception e){
        super(e);
    }

    public int getErrorLine() {
        return errorLine;
    }


}
