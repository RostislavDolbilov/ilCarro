package ilcarro.repository.app;

import ilcarro.model.app.car.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
    ModelEntity findByModel(String model);
}
