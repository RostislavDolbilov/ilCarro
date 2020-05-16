package ilcarro.model.app.car;

/* @author Rostislav Dolbilov */

import com.fasterxml.jackson.annotation.JsonFormat;
import ilcarro.dto.car.Rent;
import ilcarro.model.Base;
import ilcarro.model.app.user.UserEntity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "rents")
public class RentEntity extends Base {

    @OneToOne
    private CarEntity car;

    @JsonFormat(pattern = "yyyMMMdd")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyMMMdd")
    private LocalDateTime endTime;

    @ManyToOne
    private UserEntity userEntity;

    public RentEntity(Rent rent) {
        this.car = rent.getCar().toCarEntity();
        this.startTime = rent.getStartTime();
        this.endTime = rent.getEndTime();
    }

    public Rent toRent(){
        return new Rent(car.toCar(), startTime, endTime);
    }
}
