package com.ejemplo.nombre;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NombreService {

    private final JdbcTemplate jdbcTemplate;

    public NombreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getNombrePorCodigo(String codigo) {
        return jdbcTemplate.queryForObject(
            "SELECT pkg_personas.get_nombre(?) FROM DUAL",
            String.class,
            codigo
        );
    }
}
