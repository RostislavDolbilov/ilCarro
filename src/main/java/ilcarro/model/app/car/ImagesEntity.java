package ilcarro.model.app.car;

import ilcarro.dto.car.Images;
import ilcarro.model.auth.Base;
import lombok.*;
import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "images")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private CarEntity car;

    public ImagesEntity(Images images) {
        this.imgUrl = images.getImgUrl();
    }

    public Images toImages(){
        return new Images(imgUrl);
    }
}
