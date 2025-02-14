package com.crud.card.controller;

import com.crud.card.model.Alumno;
import com.crud.card.model.ServiceResponse;
import com.crud.card.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumno")
@CrossOrigin("*")
public class AlumnoController {

    @Autowired
    private IAlumnoService iAlumnoService;

    @GetMapping("/list")
    public ResponseEntity<List<Alumno>> list() {
        var result = iAlumnoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Alumno alumno) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnoService.save(alumno);
        if (result == 1) {
            serviceResponse.setMessage("Alumno guardado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Alumno alumno) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnoService.update(alumno);
        if (result == 1) {
            serviceResponse.setMessage("Alumno modificado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{cCorrelativo}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable String cCorrelativo) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnoService.deletedById(cCorrelativo);
        if (result == 1) {
            serviceResponse.setMessage("Alumno eliminado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}