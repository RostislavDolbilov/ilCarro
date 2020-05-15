package ilcarro.model.app.car;

import ilcarro.dto.car.Location;
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
@Table(name = "location")
public class LocationEntity extends Base {
    private String country;

    private String city;

    private String street;

    private String state;

    @OneToOne(mappedBy = "location")
    private CarEntity car;

    public LocationEntity(Location location) {
        this.country = location.getCountry();
        this.city = location.getCity();
        this.street = location.getStreet();
        this.state = location.getState();
    }

    public Location toLocation(){
        return new Location(country, city, street, state);
    }
}
