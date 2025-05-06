package qrcodeapi.exceptions;

public class InvalidImageSizeException extends RuntimeException {
    public InvalidImageSizeException(String message) {
        super(message);
    }
}
