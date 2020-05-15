package ilcarro.model.app.car;

import ilcarro.dto.car.Transmission;
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
@Table(name = "transmission")
public class TransmissionEntity extends Base {
    private String transmission;

    @OneToOne(mappedBy = "transmission")
    private CarEntity car;

    public TransmissionEntity(Transmission transmission) {
        this.transmission = transmission.getTransmission();
    }

    public Transmission toTransmission(){
        return new Transmission(transmission);
    }
}
