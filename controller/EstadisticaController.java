package com.crud.card.controller;


import com.crud.card.model.EstadisticaEdad;
import com.crud.card.service.EstadisticaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@CrossOrigin("*") // Ajusta según tu frontend
public class EstadisticaController {

    @Autowired
    private EstadisticaService estadisticaService;

    @GetMapping("/edades")
    public List<EstadisticaEdad> obtenerEstadisticas() {
        return estadisticaService.obtenerEstadisticas();
    }
}