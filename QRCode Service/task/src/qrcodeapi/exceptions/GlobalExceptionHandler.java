package qrcodeapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnknownImageTypeException.class)
    public ResponseEntity<Map<String, String>> handleUnknownStatus(UnknownImageTypeException use){
        Map<String, String> body = new HashMap<>();
        body.put("error", use.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidImageSizeException.class)
    public ResponseEntity<Map<String, String>> handleInvalidImageSize(InvalidImageSizeException iise){
        Map<String, String> body = new HashMap<>();
        body.put("error", iise.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
