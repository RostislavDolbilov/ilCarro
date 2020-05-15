package ilcarro.dto.car;

import ilcarro.model.app.car.FuelEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Fuel {
    private String fuel;

    public FuelEntity toFuelEntity() {
        FuelEntity fuelEntity = new FuelEntity();
        fuelEntity.setFuel(fuel);
        return fuelEntity;
    }
}
