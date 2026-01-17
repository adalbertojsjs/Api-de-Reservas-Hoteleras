package com.Cursos.Biblioteca1.Repository;

import com.Cursos.Biblioteca1.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {


}
