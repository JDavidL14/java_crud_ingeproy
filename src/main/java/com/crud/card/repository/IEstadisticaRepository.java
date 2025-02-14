package com.crud.card.repository;

import com.crud.card.model.EstadisticaEdad;

import java.util.List;

public interface IEstadisticaRepository {
    List<EstadisticaEdad> obtenerEstadisticas();
}