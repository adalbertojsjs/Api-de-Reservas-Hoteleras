package com.Cursos.Biblioteca1.Service;

import com.Cursos.Biblioteca1.Model.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> listar();
    Libro guardarLibro(Libro libro);
    Libro actualizar(Long id,Libro libroNuevo);
    Libro buscarPorID(Long id);
    Boolean eliminarLibro(Long id);
}
