package ilcarro.dto.car;

import ilcarro.model.app.car.TransmissionEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Transmission {
    private String transmission;

    public TransmissionEntity toTransmissionEntity() {
        TransmissionEntity transmissionEntity = new TransmissionEntity();
        transmissionEntity.setTransmission(transmission);
        return transmissionEntity;
    }
}
