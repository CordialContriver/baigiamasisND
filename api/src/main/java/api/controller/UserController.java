package api.controller;

import api.dto.User;
import api.service.MessageService;
import api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import static api.Paths.*;

@RestController
@RequestMapping(USERS)
public class UserController {
    private final UserService userService;
    private final MessageService messageService;


    public UserController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService=messageService;

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping(value = USER, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user){
        userService.addUser(user);
    }

//    @PostMapping(value = LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Login login(@AuthenticationPrincipal User user) {
//        return new Login(user);
//    }
    @PostMapping(value = LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }


}
