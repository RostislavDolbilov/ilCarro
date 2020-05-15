package ilcarro.dto.car;

import ilcarro.model.app.car.ImagesEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Images {
    private String imgUrl;

    public ImagesEntity toImagesEntity() {
        ImagesEntity imagesEntity = new ImagesEntity();
        imagesEntity.setImgUrl(imgUrl);
        return imagesEntity;
    }
}
