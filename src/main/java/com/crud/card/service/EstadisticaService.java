package com.crud.card.service;

import com.crud.card.model.EstadisticaEdad;
import com.crud.card.repository.EstadisticaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class EstadisticaService {

    @Autowired
    private EstadisticaRepository estadisticaRepository;

    public List<EstadisticaEdad> obtenerEstadisticas() {
        return estadisticaRepository.obtenerEstadisticas();
    }
}