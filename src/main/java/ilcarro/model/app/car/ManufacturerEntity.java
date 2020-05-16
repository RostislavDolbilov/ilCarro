package ilcarro.model.app.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ilcarro.dto.car.Manufacturer;
import ilcarro.dto.car.Model;
import ilcarro.model.Base;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "car")
public class ManufacturerEntity extends Base {
    private String manufacturer;

    @JsonBackReference
    @OneToMany(mappedBy = "manufacturer")
    private List<ModelEntity> models;

    public ManufacturerEntity(Manufacturer manufacturer) {
        this.manufacturer = manufacturer.getManufacturer();
        this.models = manufacturer.getModels()
                .stream()
                .map(Model::toModelEntity)
                .collect(Collectors.toList());
    }
    public Manufacturer toManufacturer(){
        return new Manufacturer(
                manufacturer,
                models
                    .stream()
                    .map(ModelEntity::toModel)
                    .collect(Collectors.toList()));
    }
}
