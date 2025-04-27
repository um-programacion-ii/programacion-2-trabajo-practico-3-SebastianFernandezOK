package com.biblioteca;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private Estado estado;

    // Constructor
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE; // Por defecto DISPONIBLE al crear
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Estado getEstado() {
        return estado;
    }

    // Setter para estado
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
