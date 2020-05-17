package ilcarro.model.app.car;

import ilcarro.dto.car.Fuel;
import ilcarro.model.auth.Base;
import lombok.*;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "fuel")
public class FuelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
