package ilcarro.model.app.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ilcarro.dto.car.Model;
import ilcarro.model.Base;
import lombok.*;
import javax.persistence.*;
import java.util.List;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "model")
public class ModelEntity extends Base {
    private String model;

    @ManyToOne
    private ManufacturerEntity manufacturer;

    @NonNull
    @JsonBackReference
    @OneToMany(mappedBy = "model")
    private List<CarEntity> cars;

    public ModelEntity(Model model) {
        this.model = model.getModel();
    }

    public Model toModel(){
        return new Model(model);
    }
}
