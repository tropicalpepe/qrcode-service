package qrcodeapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.shared.ImageType;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    @GetMapping("/health")
    public ResponseEntity<Void> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> qrcode(
            @RequestParam("size") int size,
            @RequestParam("type") ImageType imageType) {
        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0, size, size);

        return ResponseEntity
                .ok()
                .contentType(imageType.getMediaType())
                .body(bufferedImage);
    }
}
