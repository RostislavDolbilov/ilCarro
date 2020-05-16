package ilcarro.model.app.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ilcarro.dto.car.*;
import ilcarro.model.Base;
import ilcarro.model.app.user.UserEntity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "car")
public class CarEntity extends Base {
    @NonNull
    @NotEmpty
    private String serial_number;

    @ManyToOne
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity location;

    @ManyToOne
    private ModelEntity model;

    @OneToMany(mappedBy = "car")
    private List<ImagesEntity> images;

    @OneToOne
    private TransmissionEntity transmission;

    private Integer year;
    private Double engine;

    @OneToOne
    private FuelEntity fuel;

    @OneToOne
    private WheelDriveEntity wheelDrive;

    private Integer horsepower;
    private Integer torque;
    private Integer doors;
    private Integer seats;
    private String classCar;
    private Double fuelConsumption;
    private String about;
    private String features;
    private Double price;
    private Double rating;

    @JsonBackReference
    @OneToMany(mappedBy = "car")
    private List<CommentsEntity> comments;

    public CarEntity(Car car) {
        this.serial_number = car.getSerial_number();
        this.user = car.getUser().toUserEntity();
        this.location = car.getLocation().toLocationEntity();
        this.model = car.getModel().toModelEntity();
        this.images = car.getImages()
                .stream()
                .map(Images::toImagesEntity)
                .collect(Collectors.toList());
        this.transmission = car.getTransmission().toTransmissionEntity();
        this.year = car.getYear();
        this.engine = car.getEngine();
        this.fuel = car.getFuel().toFuelEntity();
        this.wheelDrive = car.getWheelDrive().toWheelDriveEntity();
        this.horsepower = car.getHorsepower();
        this.torque = car.getTorque();
        this.doors = car.getDoors();
        this.seats = car.getSeats();
        this.classCar = car.getClassCar();
        this.fuelConsumption = car.getFuelConsumption();
        this.about = car.getAbout();
        this.features = car.getFeatures();
        this.price = car.getPrice();
        this.rating = car.getRating();
    }

    public Car toCar(){
        return new Car(serial_number,
                user.toUserDto(),
                location.toLocation(),
                model.getManufacturer().toManufacturer(),
                model.toModel(),
                images.stream()
                        .map(ImagesEntity::toImages)
                        .collect(Collectors.toList()),
                transmission.toTransmission(),
                year,
                engine,
                fuel.toFuel(),
                wheelDrive.toWheelDrive(),
                horsepower,
                torque,
                doors,
                seats,
                classCar,
                fuelConsumption,
                about,
                features,
                price,
                rating,
                comments.stream()
                        .map(CommentsEntity::toComments)
                        .collect(Collectors.toList()));
    }
}
