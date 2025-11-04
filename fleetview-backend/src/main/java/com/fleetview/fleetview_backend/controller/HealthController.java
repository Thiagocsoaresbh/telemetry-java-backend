package com.fleetview.fleetview_backend.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/health")
    public Map<String, Object> checkDatabaseConnection() {
        Map<String, Object> response = new HashMap<>();
        try {
            String version = jdbcTemplate.queryForObject("SELECT version()", String.class);
            response.put("status", "UP");
            response.put("database", "PostgreSQL");
            response.put("version", version);
        } catch (Exception e) {
            response.put("status", "DOWN");
            response.put("error", e.getMessage());
        }
        return response;
    }
}
