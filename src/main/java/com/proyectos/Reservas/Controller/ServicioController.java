package com.proyectos.Reservas.Controller;

import com.proyectos.Reservas.Model.Servicio;
import com.proyectos.Reservas.Service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/servicio")
public class ServicioController {

    private final ServicioService service;

    public ServicioController(ServicioService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listar(){
        return ResponseEntity.ok().body(service.listar());//200.ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarId(@PathVariable Long id){
       Servicio servicio = service.buscarId(id);

       if (servicio == null){
           return ResponseEntity.notFound().build();//404

       }
       return ResponseEntity.ok().body(servicio);//200.ok

    }

    @PostMapping
    public ResponseEntity<Servicio> crear(@RequestBody Servicio servicios){
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(service.crear(servicios));//201

    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Long id,@RequestBody Servicio servicio){

        Servicio servicio1 = service.actualizar(id, servicio);

        if (servicio == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(servicio);

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Servicio> desactivar(@PathVariable Long id){
                Boolean servicio = service.desactivarServicio(id);

                if (!servicio){
                    return  ResponseEntity.notFound().build();//404
                }
                return ResponseEntity.noContent().build();//204

    }

}
