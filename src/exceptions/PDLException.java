package exceptions;

public class PDLException extends RuntimeException {

    public PDLException(String error){
        super(error);
    }

    public PDLException(Exception e){
        super(e);
    }

}
