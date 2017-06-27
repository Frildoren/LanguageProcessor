package errors;

import exceptions.PDLException;

public interface ErrorManager {

void writeError(PDLException exception);

}
