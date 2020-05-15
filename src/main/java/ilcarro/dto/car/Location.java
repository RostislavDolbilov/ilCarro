package ilcarro.dto.car;

import ilcarro.model.app.car.LocationEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Location {
    private String country;
    private String city;
    private String street;
    private String state;

    public LocationEntity toLocationEntity() {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCountry(country);
        locationEntity.setCity(city);
        locationEntity.setStreet(street);
        locationEntity.setState(state);
        return locationEntity;
    }
}
