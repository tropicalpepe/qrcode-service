package qrcodeapi.exceptions;

public class InvalidImageSizeException extends RuntimeException {
    public InvalidImageSizeException() {
        super("Image size must be between 150 and 350 pixels");
    }
}
