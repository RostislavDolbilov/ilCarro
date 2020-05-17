package ilcarro.rest;

import ilcarro.dto.car.Fuel;
import ilcarro.dto.car.Manufacturer;
import ilcarro.dto.user.UserBase;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.service.AppService;
import ilcarro.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ilcarro.dto.user.UserDto;

import java.util.List;

/* @author Rostislav Dolbilov */

@RestController
@RequestMapping(value = "/api/app/")
public class AppRestController {
    private final AppService appService;

    @Autowired
    public AppRestController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping(value = "registration")
    public ResponseEntity<UserDto> registration(@RequestBody UserBase userBase) throws ActionDeniedException {
        return new ResponseEntity<>(appService.registration(userBase), HttpStatus.OK);
    }

    @GetMapping(value = "get_by_username_email")
    public ResponseEntity<UserDto> getByUsernameEmail(@RequestParam String username) throws NotFoundException {
        return new ResponseEntity<>(appService.findByUsernameMail(username), HttpStatus.OK);
    }

    @GetMapping(value = "get_all_fuels")
    public ResponseEntity<List<Fuel>> getAllFuels() throws NotFoundException {
        return new ResponseEntity<>(appService.getAllFuels(), HttpStatus.OK);
    }

    @GetMapping(value = "get_all_manufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers() throws NotFoundException {
        return new ResponseEntity<>(appService.getAllManufacturers(), HttpStatus.OK);
    }
}
