package com.Cursos.Biblioteca1.Service;

import com.Cursos.Biblioteca1.Model.Libro;
import com.Cursos.Biblioteca1.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Libro> listar() {

        return repository.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return repository.save(libro);

    }


    @Override
    public Libro actualizar(Long id, Libro libroNuevo) {
        Libro libroExistente = repository.findById(id).orElse(null);
        if (libroExistente == null) {
            return null;
        }
        libroExistente.setNombre(libroNuevo.getNombre());
        libroExistente.setAutor(libroNuevo.getAutor());

        return repository.save(libroExistente);
    }


    @Override
    public Libro buscarPorID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean eliminarLibro(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
