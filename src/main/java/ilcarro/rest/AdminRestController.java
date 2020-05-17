package ilcarro.rest;

import ilcarro.dto.car.Fuel;
import ilcarro.dto.car.Manufacturer;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.User;
import ilcarro.service.AdminService;
import ilcarro.service.AppService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ilcarro.dto.user.UserAuth;
import ilcarro.service.UserService;

import java.util.List;

/* @author Rostislav Dolbilov */

@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController {

    private final AdminService adminService;

    @Autowired
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "all_registered_users")
    public ResponseEntity<List<UserAuth>> getAllRegisteredUsers() {
        return new ResponseEntity<>(adminService.getAllRegisteredUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_active_users")
    public ResponseEntity<List<UserAuth>> getAllActiveUsers() {
        return new ResponseEntity<>(adminService.getAllActiveUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_deleted_users")
    public ResponseEntity<List<UserAuth>> getAllDeletedUsers() {
        return new ResponseEntity<>(adminService.getAllDeletedUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_admin_users")
    public ResponseEntity<List<UserAuth>> getAllAdminUsers() {
        return new ResponseEntity<>(adminService.getAllAdminUsers(), HttpStatus.OK);
    }

    @PutMapping(value = "give_role_admin")
    public ResponseEntity<UserAuth> giveRoleAdmin(@RequestParam String username){
        return new ResponseEntity<>(adminService.giveRoleAdmin(username), HttpStatus.OK);
    }

    @PostMapping(value = "upload_fuel")
    public ResponseEntity<Fuel> uploadFuel(@RequestBody Fuel fuel) throws ActionDeniedException {
        return new ResponseEntity<>(adminService.uploadFuel(fuel), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete_fuel")
    public String deleteFuel(@RequestParam String fuel) throws NotFoundException {
        adminService.deleteFuel(fuel);
        return "Fuel " + fuel + " deleted successfully";
    }

    @PostMapping(value = "upload_manufacturer")
    public ResponseEntity<Manufacturer> uploadManufacturer(@RequestBody Manufacturer manufacturer) throws ActionDeniedException {
        return new ResponseEntity<>(adminService.uploadManufacturer(manufacturer), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete_manufacturer")
    public String deleteManufacturer(@RequestParam String manufacturer) throws NotFoundException {
        adminService.deleteManufacturer(manufacturer);
        return "Manufacturer " + manufacturer + " deleted successfully";
    }
}
