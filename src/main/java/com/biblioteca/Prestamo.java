package com.biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private LocalDate fechaPrestamo;
    private Libro libro;

    public Prestamo(Libro libro) {
        this.fechaPrestamo = LocalDate.now(); // Toma la fecha actual
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }
}
