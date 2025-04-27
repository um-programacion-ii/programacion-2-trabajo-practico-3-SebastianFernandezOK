package com.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {

    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-0-15-100217-7", "Rebelión en la granja", "George Orwell");
        libro2 = new Libro("978-0-452-28423-4", "1984", "George Orwell");

        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testBuscarPorIsbnExitoso() {
        Libro libroEncontrado = catalogo.buscarPorIsbn("978-0-15-100217-7");
        assertNotNull(libroEncontrado);
        assertEquals("Rebelión en la granja", libroEncontrado.getTitulo());
    }

    @Test
    void testBuscarPorIsbnFallido() {
        Libro libroEncontrado = catalogo.buscarPorIsbn("999-9-99-999999-9");
        assertNull(libroEncontrado);
    }

    @Test
    void testObtenerLibrosDisponibles() {
        libro1.setEstado(Estado.PRESTADO); // Simulamos que uno está prestado

        var disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(1, disponibles.size());
        assertEquals("1984", disponibles.get(0).getTitulo());
    }
}
