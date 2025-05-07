package qrcodeapi.exception;

public class UnknownImageTypeException extends BadRequestException {
    public UnknownImageTypeException() {
        super("Only png, jpeg and gif image types are supported");
    }
}
