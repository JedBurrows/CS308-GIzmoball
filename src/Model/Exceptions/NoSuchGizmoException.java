package Model.Exceptions;


public class NoSuchGizmoException extends Exception {
    public NoSuchGizmoException() {
        super();
    }

    public NoSuchGizmoException(String message) {
        super(message);
    }

    public NoSuchGizmoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchGizmoException(Throwable cause) {
        super(cause);
    }
}
