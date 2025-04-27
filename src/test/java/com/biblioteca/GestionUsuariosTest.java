package com.biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GestionUsuariosTest {

    @Mock
    private SistemaPrestamos sistemaPrestamos;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarPrestamo() {
        // Arrange
        Libro libro = new Libro("978-0-15-100217-7", "Rebelión en la granja", "George Orwell");
        Prestamo prestamo = new Prestamo(libro);

        when(sistemaPrestamos.prestarLibro("978-0-15-100217-7")).thenReturn(prestamo);

        gestionUsuarios.registrarUsuario("usuario1");

        // Act
        gestionUsuarios.registrarPrestamo("usuario1", "978-0-15-100217-7");

        // Assert
        Usuario usuario = gestionUsuarios.buscarUsuario("usuario1");
        assertNotNull(usuario);
        assertEquals(1, usuario.getHistorialPrestamos().size());
        assertEquals(libro, usuario.getHistorialPrestamos().get(0).getLibro());
    }
}
