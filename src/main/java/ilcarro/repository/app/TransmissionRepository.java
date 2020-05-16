package ilcarro.repository.app;

import ilcarro.model.app.car.TransmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<TransmissionEntity, Integer> {
    TransmissionEntity findByTransmission(String transmission);
}
