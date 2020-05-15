package ilcarro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ilcarro.dto.user.UserAuth;
import ilcarro.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "all_registered_users")
    public ResponseEntity<List<UserAuth>> getAllRegisteredUsers() {
        return new ResponseEntity<>(userService.getAllRegisteredUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_active_users")
    public ResponseEntity<List<UserAuth>> getAllActiveUsers() {
        return new ResponseEntity<>(userService.getAllActiveUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_deleted_users")
    public ResponseEntity<List<UserAuth>> getAllDeletedUsers() {
        return new ResponseEntity<>(userService.getAllDeletedUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "all_admin_users")
    public ResponseEntity<List<UserAuth>> getAllAdminUsers() {
        return new ResponseEntity<>(userService.getAllAdminUsers(), HttpStatus.OK);
    }
}
