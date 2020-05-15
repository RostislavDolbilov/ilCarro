package ilcarro.rest;

import ilcarro.service.AdminService;
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
}
