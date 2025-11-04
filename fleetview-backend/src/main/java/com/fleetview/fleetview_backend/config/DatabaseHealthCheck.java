package com.fleetview.fleetview_backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthCheck implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseHealthCheck(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("🔍 Verificando conexão com o banco de dados...");

        try {
            String result = jdbcTemplate.queryForObject("SELECT version()", String.class);
            System.out.println("✅ Conectado ao PostgreSQL com sucesso!");
            System.out.println("ℹ️  Versão: " + result);
        } catch (Exception e) {
            System.out.println("❌ Falha ao conectar ao PostgreSQL:");
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
