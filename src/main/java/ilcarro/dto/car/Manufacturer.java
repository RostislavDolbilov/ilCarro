package ilcarro.dto.car;

import ilcarro.model.app.car.ManufacturerEntity;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Manufacturer {
    private String manufacturer;
    private List<Model> models;

    public ManufacturerEntity toManufacturer(){
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
        manufacturerEntity.setManufacturer(manufacturer);
        manufacturerEntity.setModels(models
                .stream()
                .map(Model::toModelEntity)
                .collect(Collectors.toList()));
        return manufacturerEntity;
    }
}
