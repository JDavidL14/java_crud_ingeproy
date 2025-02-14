package com.crud.card.service;

import com.crud.card.model.Alumno;
import com.crud.card.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    @Override
    public List<Alumno> findAll() {
        List<Alumno> list;
        try {
            list = iAlumnoRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Alumno alumno) {
        int row;
        try {
            row = iAlumnoRepository.save(alumno);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Alumno alumno) {
        int row;
        try {
            row = iAlumnoRepository.update(alumno);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int deletedById(String cCorrelativo) {
        int row;
        try {
            row = iAlumnoRepository.deletedById(cCorrelativo);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
}