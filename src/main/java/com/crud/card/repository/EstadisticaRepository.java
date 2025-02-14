package com.crud.card.repository;

import com.crud.card.model.Alumno;
import com.crud.card.model.EstadisticaEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstadisticaRepository implements IEstadisticaRepository {

    private final JdbcTemplate jdbcTemplate;

    public EstadisticaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EstadisticaEdad> obtenerEstadisticas() {
        String sql = "exec Estadisticas_Alumnos_Por_Edad";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EstadisticaEdad.class));
    }
}