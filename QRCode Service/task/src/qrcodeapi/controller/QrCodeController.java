package qrcodeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.exception.InvalidCorrectionLevel;
import qrcodeapi.exception.InvalidImageSizeException;
import qrcodeapi.exception.MissingContentsException;
import qrcodeapi.model.CorrectionLevel;
import qrcodeapi.model.ImageType;
import qrcodeapi.service.QrCodeService;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class QrCodeController {
    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/health")
    public ResponseEntity<Void> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> qrcode(
            @RequestParam(name = "size", defaultValue = "250") int size,
            @RequestParam(name = "type", defaultValue = "png") String type,
            @RequestParam(name = "contents") String contents,
            @RequestParam(name = "correction", defaultValue = "L") String correction
            ) {
        assertContentsPresent(contents);
        assertSizeInRange(size);
        CorrectionLevel correctionLevel = requireCorrectionLevel(correction);
        ImageType imageType = ImageType.fromValue(type);

        BufferedImage bufferedImage = qrCodeService.generateQr(contents, size, correctionLevel);

        return ResponseEntity
                .ok()
                .contentType(imageType.getMediaType())
                .body(bufferedImage);
    }
    private void assertContentsPresent(String contents){
        if (contents == null || contents.isBlank()){
            throw new MissingContentsException();
        }
    }

    private void assertSizeInRange(int size) {
        if (size < 150 || size > 350) {
            throw new InvalidImageSizeException();
        }
    }

    private CorrectionLevel requireCorrectionLevel(String correction){
        try {
            return CorrectionLevel.valueOf(correction);
        } catch (IllegalArgumentException iae) {
            throw new InvalidCorrectionLevel();
        }
    }
}
