package ilcarro.dto.car;

import ilcarro.model.app.car.WheelDriveEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class WheelDrive {
    private String wheelDrive;

    public WheelDriveEntity toWheelDriveEntity() {
        WheelDriveEntity wheelDriveEntity = new WheelDriveEntity();
        wheelDriveEntity.setWheelDrive(wheelDrive);
        return wheelDriveEntity;
    }
}
