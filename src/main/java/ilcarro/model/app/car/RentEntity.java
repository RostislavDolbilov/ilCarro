package ilcarro.model.app.car;

/* @author Rostislav Dolbilov */

import com.fasterxml.jackson.annotation.JsonFormat;
import ilcarro.dto.car.Rent;
import ilcarro.model.auth.Base;
import ilcarro.model.app.user.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "rents")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
