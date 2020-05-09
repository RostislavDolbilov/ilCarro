package security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.dto.UserBaseDto;
import security.dto.UserDto;
import security.exeptions.ActionDeniedException;
import security.model.app.UserEntity;
import security.service.UserService;

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
}
