package com.biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogo; // Simulamos el catálogo

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos; // Inyectamos el mock en el sistema de préstamos

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializamos los mocks
    }

    @Test
    void testPrestarLibro() {
        // Arrange
        Libro libro = new Libro("978-0-15-100217-7", "Rebelión en la granja", "George Orwell");
        when(catalogo.buscarPorIsbn("978-0-15-100217-7")).thenReturn(libro);

        // Act
        Prestamo prestamo = sistemaPrestamos.prestarLibro("978-0-15-100217-7");

        // Assert
        assertNotNull(prestamo);
        assertEquals(libro, prestamo.getLibro());
        assertEquals(Estado.PRESTADO, libro.getEstado());
        verify(catalogo).buscarPorIsbn("978-0-15-100217-7");
    }
}
