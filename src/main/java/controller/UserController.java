package controller;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        userService.login(user);
        return new ResponseEntity<>("User added successfully!!", HttpStatus.OK);
    }
}
