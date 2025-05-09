package qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import qrcodeapi.exception.QrCodeGenerationError;
import qrcodeapi.model.CorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public class QrCodeService {

    public BufferedImage generateQr(String contents, int size, CorrectionLevel correctionLevel) {
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, ?> hints = Map.of(
                EncodeHintType.ERROR_CORRECTION, correctionLevel.getErrorCorrectionLevel()
        );
        BufferedImage bufferedImage;
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size, hints);
            bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new QrCodeGenerationError();
        }
        return bufferedImage;
    }
}
