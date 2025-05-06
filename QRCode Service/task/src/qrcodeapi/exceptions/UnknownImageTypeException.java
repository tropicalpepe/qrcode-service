package qrcodeapi.exceptions;

public class UnknownImageTypeException extends RuntimeException {
    public UnknownImageTypeException(String message) {
        super(message);
    }
}
