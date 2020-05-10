package ilcarro.rest;

import ilcarro.dto.UserBaseDto;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ilcarro.dto.UserDto;

@RestController
@RequestMapping(value = "/api/app/")
public class AppRestController {
    private final UserService userService;

    @Autowired
    public AppRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public ResponseEntity<UserDto> registration(@RequestBody UserBaseDto userBaseDto) throws ActionDeniedException {
        return new ResponseEntity<>(userService.registration(userBaseDto), HttpStatus.OK);
    }

    @GetMapping("get_by_username_email")
    public ResponseEntity<UserDto> getByUsernameEmail(@RequestParam String username) throws NotFoundException {
        return new ResponseEntity<>(userService.findByUsernameMail(username), HttpStatus.OK);
    }
}
