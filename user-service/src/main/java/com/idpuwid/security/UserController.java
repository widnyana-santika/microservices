package com.idpuwid.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

//    private UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    @GetMapping("/user")
    public String getUsers(){
        return "Hello Users!";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello Admin!";
    }

//    @GetMapping
//    public ResponseEntity<List<AppUser>> getUsers(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }
}
