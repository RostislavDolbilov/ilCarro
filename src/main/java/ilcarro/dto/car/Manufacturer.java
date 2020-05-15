package ilcarro.dto.car;

import lombok.*;
import java.util.List;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Manufacturer {
    private String manufacturer;
    private List<Model> models;
}
