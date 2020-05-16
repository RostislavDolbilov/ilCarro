package ilcarro.dto.car;

import ilcarro.model.app.car.RentEntity;
import lombok.*;
import java.time.LocalDateTime;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Rent {
    private Car car;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public RentEntity toRentEntity(){
        RentEntity rentEntity = new RentEntity();
        rentEntity.setCar(car.toCarEntity());
        rentEntity.setStartTime(startTime);
        rentEntity.setEndTime(endTime);
        return rentEntity;
    }
}
