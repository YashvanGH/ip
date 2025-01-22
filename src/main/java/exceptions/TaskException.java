package exceptions;

public class TyreseException extends Exception {

    // The 3 constructors below follow the Exception class
    public TyreseException() {
        super();
    }

    public TyreseException(String message) {
        super(message);
    }

    public TyreseException(String message, Throwable cause) {
        super(message, cause);
    }

}
