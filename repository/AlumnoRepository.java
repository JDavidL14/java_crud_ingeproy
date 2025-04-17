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
    public void insertarAlumnos(int cantidad) {
        String sql = "EXEC InsertarAlumnos ?";
        jdbcTemplate.update(sql, cantidad);
    }
    @Override
    public List<Alumno> findAll() {
        String SQL = "SELECT * FROM alumno ";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Alumno.class));
    }

    @Override
    public int save(Alumno alumno) {
        String SQL = "INSERT INTO alumno \n" +
                "                (carrera, anio, correlativo, pnombre, snombre, papellido, sapellido, telefono, email, institucion, tipo_participante, qrcode, boleta) \n" +
                "            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, new Object[]{
                alumno.getCarrera(), alumno.getAnio(), alumno.getCorrelativo(),
                alumno.getPnombre(), alumno.getSnombre(), alumno.getPapellido(),
                alumno.getSapellido(), alumno.getTelefono(), alumno.getEmail(),
                alumno.getInstitucion(), alumno.getTipoParticipante(),
                alumno.getQrcode(), alumno.getBoleta()
        });
    }

    @Override
    public int update(Alumno alumno) {
        String SQL = "UPDATE alumno SET pnombre=?, snombre=?, papellido=?, sapellido=?, telefono=?, email=?, institucion=?, tipo_participante=?,qrcode=?, boleta=? WHERE carrera=? AND anio=? AND correlativo=?";
        return jdbcTemplate.update(SQL, new Object[]{
                alumno.getPnombre(), alumno.getSnombre(), alumno.getPapellido(),
                alumno.getSapellido(), alumno.getTelefono(), alumno.getEmail(),
                alumno.getInstitucion(), alumno.getTipoParticipante(),
                alumno.getQrcode(), alumno.getBoleta(),
                alumno.getCarrera(), alumno.getAnio(), alumno.getCorrelativo()
        });
    }

    @Override
    public int deletedById(String correlativo) {
        String SQL = "UPDATE alumno SET status=0 WHERE correlativo=?";
        return jdbcTemplate.update(SQL, new Object[]{correlativo});
    }

    public Alumno findByCorrelativo(String correlativo) {
        String SQL = "SELECT * FROM alumno WHERE correlativo = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{correlativo}, new BeanPropertyRowMapper<>(Alumno.class));
    }

}
