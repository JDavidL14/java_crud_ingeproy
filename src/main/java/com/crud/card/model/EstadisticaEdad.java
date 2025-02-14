package com.crud.card.model;

public class EstadisticaEdad {
    private int edad;
    private int cantidad;

    // Constructor vacío (necesario para Spring)
    public EstadisticaEdad() {
    }

    // Constructor con parámetros
    public EstadisticaEdad(int edad, int cantidad) {
        this.edad = edad;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}