package com.proyectos.Reservas.Controller;


import com.proyectos.Reservas.Model.Turno;
import com.proyectos.Reservas.Service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/v1/turnos")
public class ComtrollerTurno {

   private final TurnoService turnoService;

    public ComtrollerTurno(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar(){
        return  ResponseEntity.ok().body(turnoService.listar());//200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id){
        Turno turno = turnoService.buscarPorId(id);
        if (turno == null) {
           return ResponseEntity.notFound().build();//404
        }
       return ResponseEntity.ok(turno);//200.ok
    }


    @PostMapping
    public ResponseEntity<Turno> crear(@RequestBody Turno turno){
        return  ResponseEntity.status(HttpStatus.CREATED).body(turnoService.crear(turno));//201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizar(@PathVariable Long id, @RequestBody Turno turno){
        Turno existe = turnoService.actualizar(id, turno);

        if (existe == null){
         return  ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok(existe);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id){
         boolean existe = turnoService.cancelar(id);
        if (!existe){
            return  ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.noContent().build();//204

    }
}
