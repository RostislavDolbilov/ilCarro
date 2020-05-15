package ilcarro.rest;

import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ilcarro.service.UserService;

/* @author Rostislav Dolbilov */

@RestController
@RequestMapping(value = "/api/user/")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("deleted_user")
    public ResponseEntity<UserDto> deletedUser(@RequestParam String username) throws NotFoundException {
        return new ResponseEntity<>(userService.deleteUser(username), HttpStatus.OK);
    }

    @PutMapping("return_user")
    public ResponseEntity<UserDto> returnUser(@RequestParam String username){
        return new ResponseEntity<>(userService.returnUser(username), HttpStatus.OK);
    }
}
