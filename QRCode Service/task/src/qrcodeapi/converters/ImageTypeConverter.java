package qrcodeapi.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import qrcodeapi.shared.ImageType;

@Component
public class ImageTypeConverter implements Converter<String, ImageType> {
    @Override
    public ImageType convert(@NonNull String imageType) {
        return ImageType.fromValue(imageType);
    }
}
