package com.crud.card.controller;

import com.crud.card.model.Alumno;
import com.crud.card.model.ServiceResponse;
import com.crud.card.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ContentDisposition;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumno")
@CrossOrigin("*")
public class AlumnoController {

    @Autowired
    private IAlumnoService iAlumnoService;


    @PostMapping("/insertar")
    public ResponseEntity<String> insertarAlumnos(@RequestParam int cantidad) {
        iAlumnoService.insertarAlumnos(cantidad);
        return ResponseEntity.ok("Se insertaron " + cantidad + " alumnos correctamente.");
    }

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

    @GetMapping("/qr/{cCorrelativo}")
    public ResponseEntity<byte[]> getQR(@PathVariable String cCorrelativo) {
        byte[] qrCode = iAlumnoService.getQRByCorrelativo(cCorrelativo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentDisposition(ContentDisposition.attachment().filename("qr_" + cCorrelativo + ".png").build());

        return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
    }

}