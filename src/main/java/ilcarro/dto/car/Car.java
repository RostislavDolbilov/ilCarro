package ilcarro.dto.car;

import ilcarro.dto.user.UserDto;
import ilcarro.model.app.car.CarEntity;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Car {
    private UserDto user;
    private Location location;
    private Manufacturer manufacturer;
    private Model model;
    private List<Images> images;
    private Transmission transmission;
    private Integer year;
    private Double engine;
    private Fuel fuel;
    private WheelDrive wheelDrive;
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
    private List<Comments> comments;

    public CarEntity toCarEntity(){
        CarEntity carEntity = new CarEntity();
        carEntity.setUser(user.toUserEntity());
        carEntity.setLocation(location.toLocationEntity());
        carEntity.setModel(model.toModelEntity());
        carEntity.setImages(images
                .stream()
                .map(Images::toImagesEntity)
                .collect(Collectors.toList()));
        carEntity.setTransmission(transmission.toTransmissionEntity());
        carEntity.setYear(year);
        carEntity.setEngine(engine);
        carEntity.setFuel(fuel.toFuelEntity());
        carEntity.setWheelDrive(wheelDrive.toWheelDriveEntity());
        carEntity.setHorsepower(horsepower);
        carEntity.setTorque(torque);
        carEntity.setDoors(doors);
        carEntity.setSeats(seats);
        carEntity.setClassCar(classCar);
        carEntity.setFuelConsumption(fuelConsumption);
        carEntity.setAbout(about);
        carEntity.setFeatures(features);
        carEntity.setPrice(price);
        carEntity.setRating(rating);
        carEntity.setComments(comments
                .stream()
                .map(Comments::toCommentsEntity)
                .collect(Collectors.toList()));
        return carEntity;
    }
}
