package ilcarro.model.app.car;

import ilcarro.dto.car.WheelDrive;
import ilcarro.model.auth.Base;
import lombok.*;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "wheel_drive")
public class WheelDriveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
