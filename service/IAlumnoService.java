package com.crud.card.service;

import com.crud.card.model.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<Alumno> findAll();
    int save(Alumno alumno);
    int update(Alumno alumno);
    int deletedById(String cCorrelativo);

    void insertarAlumnos(int cantidad);

    Alumno findByCorrelativo(String cCorrelativo);

    byte[] getQRByCorrelativo(String correlativo);

}

