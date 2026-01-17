package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Servicio;

import java.util.List;

public interface ServicioService {


    Servicio buscarId(Long id);

    Servicio crear(Servicio servicio);
    Servicio actualizar(Long id, Servicio servicio);

    List<Servicio> listar();
    Boolean desactivarServicio(Long id);

}
