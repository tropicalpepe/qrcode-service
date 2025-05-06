package qrcodeapi.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import qrcodeapi.exceptions.InvalidImageSizeException;

@Aspect
@Component
public class QRCodeAdvice {

    @Before("execution(* qrcodeapi.controllers.QRCodeController.qrcode(..)) && args(size, ..)")
    public void validateQrCodeParams(int size) {
        if (size < 150 || size > 350) {
            throw new InvalidImageSizeException("Image size must be between 150 and 350 pixels");
        }
    }
}
