package qrcodeapi.model;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public enum CorrectionLevel {
    L(ErrorCorrectionLevel.L),
    M(ErrorCorrectionLevel.M),
    Q(ErrorCorrectionLevel.Q),
    H(ErrorCorrectionLevel.H);

    private final ErrorCorrectionLevel errorCorrectionLevel;

    CorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }
}
