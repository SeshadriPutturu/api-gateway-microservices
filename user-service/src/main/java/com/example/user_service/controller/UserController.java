package com.example.user_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public Map<String, String> getUser(@PathVariable String id) {
        return Map.of(
                "id", id,
                "name", "Seshadri",
                "service", "USER-SERVICE"
        );
    }
}
