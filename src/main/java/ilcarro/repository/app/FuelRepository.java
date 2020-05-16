package ilcarro.repository.app;

import ilcarro.model.app.car.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* @author Rostislav Dolbilov */

public interface FuelRepository extends JpaRepository<FuelEntity, Integer> {
    FuelEntity findByFuel(String fuel);
}
