package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Cliente;

import java.util.List;

public interface ClientesService {

    List<Cliente> listar();

    Cliente crear(Cliente cliente);

    Cliente buscarPorId(Long id);

    Cliente actualizar(Long id ,Cliente cliente);

     Cliente desactivar(Long id);
}
