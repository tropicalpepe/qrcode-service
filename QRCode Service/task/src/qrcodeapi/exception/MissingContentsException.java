package qrcodeapi.exception;

public class MissingContentsException extends BadRequestException {
    public MissingContentsException() {
        super("Contents cannot be null or blank");
    }
}
