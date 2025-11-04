package com.fleetview.fleetview_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FleetviewBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleetviewBackendApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/api/test")
        public String hello() {
            return "Backend FleetView running!";
        }
    }
}
