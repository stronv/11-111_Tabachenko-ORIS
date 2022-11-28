package util;

public class Dbexception extends Exception {
    public Dbexception() {
    }

    public Dbexception(String message) {
        super(message);
    }

    public Dbexception(String message, Throwable cause) {
        super(message, cause);
    }

    public Dbexception(Throwable cause) {
        super(cause);
    }

    public Dbexception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
