package security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.dto.UserAuthDto;
import security.dto.UserDto;
import security.service.UserService;

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
    public ResponseEntity<List<UserAuthDto>> getAllRegisteredUsers() {
        return new ResponseEntity<>(userService.getAllRegisteredUsers(), HttpStatus.OK);
    }
}
