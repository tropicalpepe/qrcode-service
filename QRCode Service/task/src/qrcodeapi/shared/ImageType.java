package qrcodeapi.shared;

import org.springframework.http.MediaType;
import qrcodeapi.exceptions.UnknownImageTypeException;

import java.awt.*;

public enum ImageType {
    PNG("png", MediaType.IMAGE_PNG),
    JPEG("jpeg", MediaType.IMAGE_JPEG),
    GIF("gif", MediaType.IMAGE_GIF);

    private final String value;
    private final MediaType mediaType;

    ImageType(String value, MediaType mediaType) {
        this.value = value;
        this.mediaType = mediaType;
    }

    public String getValue() {
        return value;
    }
    public MediaType getMediaType() {return mediaType;}

    public static ImageType fromValue(String value){
        for (ImageType status : ImageType.values()) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new UnknownImageTypeException("Only png, jpeg and gif image types are supported");
    }

}
