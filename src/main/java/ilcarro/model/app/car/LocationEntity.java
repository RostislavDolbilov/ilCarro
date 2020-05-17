package ilcarro.model.app.car;

import ilcarro.dto.car.Location;
import ilcarro.model.auth.Base;
import lombok.*;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "location")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
