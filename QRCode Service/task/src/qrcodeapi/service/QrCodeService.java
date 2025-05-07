package qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import qrcodeapi.exception.QrCodeGenerationError;

import java.awt.image.BufferedImage;

@Service
public class QrCodeService {

    public BufferedImage generateQr(String contents, int size) {
        QRCodeWriter writer = new QRCodeWriter();
        BufferedImage bufferedImage;
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size);
            bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new QrCodeGenerationError();
        }
        return bufferedImage;
    }
}
