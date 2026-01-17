package com.proyectos.Reservas.Controller;

import com.proyectos.Reservas.Model.Cliente;
import com.proyectos.Reservas.Service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ControllerClientes {

    private final ClientesService clienteService;

    public ControllerClientes(ClientesService clienteService1){
        this.clienteService = clienteService1;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok().body(clienteService.listar());//200

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        Cliente cliente = clienteService.buscarPorId(id);

        if (cliente == null){
            return  ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok().body(cliente);//200.ok

    }

    @PutMapping("/{id}/")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id,@RequestBody Cliente cliente){
        Cliente d = clienteService.actualizar( id,cliente);

        if (d == null){
          return   ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok(d);



    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
      return ResponseEntity.status(HttpStatus
               .CREATED).body(clienteService.crear(cliente));//201
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> desactivar(@PathVariable Long id){
       Cliente s = clienteService.desactivar(id);

       if (s == null){
       return ResponseEntity.notFound().build();//404
       }

       return ResponseEntity.noContent().build();//204
    }

}
