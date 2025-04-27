package com.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void testCrearLibroValido() {
        Libro libro = new Libro("978-0-15-100217-7", "Rebelión en la granja", "George Orwell");

        assertEquals("978-0-15-100217-7", libro.getIsbn());
        assertEquals("Rebelión en la granja", libro.getTitulo());
        assertEquals("George Orwell", libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    void testCambioEstadoLibro() {
        Libro libro = new Libro("978-0-15-100217-7", "Rebelión en la granja", "George Orwell");
        libro.setEstado(Estado.PRESTADO);

        assertEquals(Estado.PRESTADO, libro.getEstado());
    }
}
