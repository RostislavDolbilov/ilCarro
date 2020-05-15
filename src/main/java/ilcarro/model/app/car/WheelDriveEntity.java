package ilcarro.model.app.car;

import ilcarro.dto.car.WheelDrive;
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
@Table(name = "wheel_drive")
public class WheelDriveEntity extends Base {
    private String wheelDrive;

    @OneToOne(mappedBy = "wheelDrive")
    private CarEntity car;

    public WheelDriveEntity(WheelDrive wheelDrive) {
        this.wheelDrive = wheelDrive.getWheelDrive();
    }

    public WheelDrive toWheelDrive(){
        return new WheelDrive(wheelDrive);
    }
}
