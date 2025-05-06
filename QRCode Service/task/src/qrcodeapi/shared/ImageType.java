package qrcodeapi.shared;

import qrcodeapi.exceptions.UnknownImageTypeException;

public enum ImageType {
    PNG("png"),
    JPEG("jpeg"),
    GIF("gif");

    private final String value;

    ImageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ImageType fromValue(String value){
        for (ImageType status : ImageType.values()) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new UnknownImageTypeException("Only png, jpeg and gif image types are supported");
    }
}
