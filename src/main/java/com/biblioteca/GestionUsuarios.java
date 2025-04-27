package com.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GestionUsuarios {

    private Map<String, Usuario> usuarios;
    private SistemaPrestamos sistemaPrestamos;

    public GestionUsuarios(SistemaPrestamos sistemaPrestamos) {
        this.sistemaPrestamos = Objects.requireNonNull(sistemaPrestamos, "El sistema de préstamos no puede ser null");
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(String nombre) {
        if (usuarios.containsKey(nombre)) {
            throw new IllegalArgumentException("El usuario ya existe: " + nombre);
        }
        usuarios.put(nombre, new Usuario(nombre));
    }

    public void registrarPrestamo(String nombreUsuario, String isbn) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado: " + nombreUsuario);
        }
        Prestamo prestamo = sistemaPrestamos.prestarLibro(isbn);
        usuario.agregarPrestamo(prestamo);
    }

    public Usuario buscarUsuario(String nombre) {
        return usuarios.get(nombre);
    }
}
