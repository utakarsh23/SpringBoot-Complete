package com.example.crud.Controller;

import com.example.crud.Entity.User;
import com.example.crud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public String check(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void CreateUsers(@RequestBody User user) {
        userService.saveEntry(user);
    }


}
