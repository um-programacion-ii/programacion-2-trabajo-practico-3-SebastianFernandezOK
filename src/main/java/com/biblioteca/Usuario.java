package com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private String nombre;
    private List<Prestamo> historialPrestamos;

    public Usuario(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser null");
        this.historialPrestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(Objects.requireNonNull(prestamo, "El préstamo no puede ser null"));
    }
}
