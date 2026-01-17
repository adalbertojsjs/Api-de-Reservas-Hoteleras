package com.Cursos.Biblioteca1.Controller;


import com.Cursos.Biblioteca1.Model.Libro;
import com.Cursos.Biblioteca1.Service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/libros")
public class Controller {

    private final LibroService service;

    public Controller(LibroService service) {
        this.service = service;
    }


    @GetMapping
    public List<Libro> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro){
        return  ResponseEntity.status(HttpStatus.CREATED).
                body(service.guardarLibro(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id,@RequestBody Libro libro){
        Libro actualizado = service.actualizar(id,libro);

        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(actualizado);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Long id){
        Libro libro = service.buscarPorID(id);
       if (libro == null){
           return  ResponseEntity.notFound().build();//404
       }else{
           return ResponseEntity.ok(libro);//200.ok
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        Boolean eliminado = service.eliminarLibro(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();//404
        } else {
            return ResponseEntity.noContent().build();//204
        }
    }


}
