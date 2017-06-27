package errors;

import exceptions.PDLException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorManagerImpl implements ErrorManager {

    private BufferedWriter writerErrors;

    public ErrorManagerImpl() throws IOException {
        writerErrors = new BufferedWriter(new FileWriter("errors.txt"));
    }

    @Override
    public void writeError(PDLException exception) {
        try {
            writerErrors.write("Error in line ".concat(String.valueOf(exception.getErrorLine()+1).concat(": ")));
            writerErrors.write(exception.getMessage());
            writerErrors.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
