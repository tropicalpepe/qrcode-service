package qrcodeapi.exception;

public class InvalidCorrectionLevel extends BadRequestException {
    public InvalidCorrectionLevel() {
        super("Permitted error correction levels are L, M, Q, H");
    }
}
