package com.Cursos.Biblioteca1.Model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String autor;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.DISPONIBLE;

    //  Constructor vacío (OBLIGATORIO para JPA)
    public Libro() {
    }

    //  Constructor útil
    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE;
    }

    //  Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Estado isPrestado() {
        return estado;
    }

    public Estado setPrestado(boolean prestado) {
       return this.estado = Estado.PRESTADO;
    }
}

