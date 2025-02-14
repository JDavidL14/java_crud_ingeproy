package com.crud.card.repository;

import com.crud.card.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepository implements IAlumnoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Alumno> findAll() {
        String SQL = "SELECT * FROM alumno WHERE status = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Alumno.class));
    }

    @Override
    public int save(Alumno alumno) {
        String SQL = "INSERT INTO alumno (carrera, anio, correlativo, pnombre, snombre, papellido, sapellido, telefono, email, fenacimiento, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, new Object[]{
                alumno.getCarrera(), alumno.getAnio(), alumno.getCorrelativo(),
                alumno.getPnombre(), alumno.getSnombre(), alumno.getPapellido(),
                alumno.getSapellido(), alumno.getTelefono(), alumno.getEmail(),
                alumno.getFenacimiento(), 1
        });
    }

    @Override
    public int update(Alumno alumno) {
        String SQL = "UPDATE alumno SET pnombre=?, snombre=?, papellido=?, sapellido=?, telefono=?, email=?, fenacimiento=? WHERE carrera=? AND anio=? AND correlativo=?";
        return jdbcTemplate.update(SQL, new Object[]{
                alumno.getPnombre(), alumno.getSnombre(), alumno.getPapellido(),
                alumno.getSapellido(), alumno.getTelefono(), alumno.getEmail(),
                alumno.getFenacimiento(), alumno.getCarrera(), alumno.getAnio(), alumno.getCorrelativo()
        });
    }

    @Override
    public int deletedById(String correlativo) {
        String SQL = "UPDATE alumno SET status=0 WHERE correlativo=?";
        return jdbcTemplate.update(SQL, new Object[]{correlativo});
    }
}
