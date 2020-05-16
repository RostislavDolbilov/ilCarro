package ilcarro.repository.app;

import ilcarro.model.app.car.WheelDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WheelDriveRepository extends JpaRepository<WheelDriveEntity, Integer> {
    WheelDriveEntity findByWheelDrive(String wheelDrive);
}
