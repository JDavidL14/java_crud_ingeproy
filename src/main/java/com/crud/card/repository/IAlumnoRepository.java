package com.crud.card.repository;

import com.crud.card.model.Alumno;

import java.util.List;

public interface IAlumnoRepository {
    List<Alumno> findAll();
    int save(Alumno alumno);
    int update(Alumno alumno);
    int deletedById(String cCorrelativo);
}