package com.biblioteca;

public class SistemaPrestamos {

    private Catalogo catalogo;

    public SistemaPrestamos(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Prestamo prestarLibro(String isbn) {
        Libro libro = catalogo.buscarPorIsbn(isbn);
        if (libro == null) {
            throw new IllegalArgumentException("El libro con ISBN " + isbn + " no existe en el catálogo.");
        }
        if (libro.getEstado() == Estado.PRESTADO) {
            throw new IllegalStateException("El libro ya está prestado.");
        }

        libro.setEstado(Estado.PRESTADO);
        return new Prestamo(libro);
    }
}
