package qrcodeapi.exception;

public class InvalidImageSizeException extends BadRequestException {
    public InvalidImageSizeException() {
        super("Image size must be between 150 and 350 pixels");
    }
}
