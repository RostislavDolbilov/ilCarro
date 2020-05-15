package ilcarro.dto.car;

import ilcarro.model.app.car.ModelEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Model {
    private String model;

    public ModelEntity toModelEntity(){
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setModel(model);
        return modelEntity;
    }
}
