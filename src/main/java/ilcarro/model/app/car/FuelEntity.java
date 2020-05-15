package ilcarro.model.app.car;

import ilcarro.dto.car.Fuel;
import ilcarro.model.Base;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "fuel")
public class FuelEntity extends Base {
    private String fuel;

    @OneToOne(mappedBy = "fuel")
    private CarEntity car;

    public FuelEntity(Fuel fuel) {
        this.fuel = fuel.getFuel();
    }

    public Fuel toFuel(){
        return new Fuel(fuel);
    }
}
