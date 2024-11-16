package com.example.crud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck { //it is just a sample to check if the server is running well or not
    @GetMapping("/check")
    public String HealthCheck() {
        return "Cool here";
    }
}
