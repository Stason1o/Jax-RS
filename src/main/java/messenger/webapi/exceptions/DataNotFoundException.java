package messenger.webapi.exceptions;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1234353705948390285L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
