package com.example.order_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Map<String, String> getOrder(@PathVariable String id) {
        return Map.of(
                "orderId", id,
                "status", "SUCCESS",
                "service", "ORDER-SERVICE"
        );
    }
}
