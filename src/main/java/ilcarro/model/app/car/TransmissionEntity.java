package ilcarro.model.app.car;

import ilcarro.dto.car.Transmission;
import ilcarro.model.auth.Base;
import lombok.*;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "transmission")
public class TransmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
