package qrcodeapi.exception;

public class QrCodeGenerationError extends BadRequestException {
    public QrCodeGenerationError() {
        super("Failed to generate QR code");
    }
}
