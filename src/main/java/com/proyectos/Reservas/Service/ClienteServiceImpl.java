package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Activo;
import com.proyectos.Reservas.Model.Cliente;
import com.proyectos.Reservas.Repository.ClienteRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteServiceImpl implements ClientesService{

    ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        cliente.setActvo(Activo.ACTIVO);
        return repository.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente actualizar( Long id,Cliente cliente) {
        if (cliente.getCliente_id() == null) {
            throw new RuntimeException("El id del cliente es obligatorio");
        }

        Cliente c = repository.findById(cliente.getCliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));


        c.setActvo(cliente.getActvo());
        c.setNombre(cliente.getNombre());
        c.setCorreo(cliente.getCorreo());

        return repository.save(c);
    }

    @Override
    public Cliente desactivar(Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("EL id debe ser mayor a cero");
        }
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.setActvo(Activo.DESACTIVO);
        return  repository.save(cliente);


    }
}
