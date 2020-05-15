package ilcarro.rest;

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

/* @author Rostislav Dolbilov */

@RestController
@RequestMapping(value = "/api/app/")
public class AppRestController {
    private final AppService appService;

    @Autowired
    public AppRestController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("registration")
    public ResponseEntity<UserDto> registration(@RequestBody UserBase userBase) throws ActionDeniedException {
        return new ResponseEntity<>(appService.registration(userBase), HttpStatus.OK);
    }

    @GetMapping("get_by_username_email")
    public ResponseEntity<UserDto> getByUsernameEmail(@RequestParam String username) throws NotFoundException {
        return new ResponseEntity<>(appService.findByUsernameMail(username), HttpStatus.OK);
    }
}
