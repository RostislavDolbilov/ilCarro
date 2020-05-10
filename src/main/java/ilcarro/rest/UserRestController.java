package ilcarro.rest;

import ilcarro.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ilcarro.service.UserService;

@RestController
@RequestMapping(value = "/api/user/")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("deleted_user")
    public ResponseEntity<UserDto> deletedUser(@RequestParam String username){
        return new ResponseEntity<>(userService.deleteUser(username), HttpStatus.OK);
    }
}
