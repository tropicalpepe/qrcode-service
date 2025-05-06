package qrcodeapi.exceptions;

public class UnknownImageTypeException extends RuntimeException {
    public UnknownImageTypeException() {
        super("Only png, jpeg and gif image types are supported");
    }
}
