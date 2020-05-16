package ilcarro.repository.app;

import ilcarro.model.app.car.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* @author Rostislav Dolbilov */

public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Integer> {
    ManufacturerEntity findByManufacturer(String manufacturer);
}
