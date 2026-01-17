package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Turno;

import java.util.List;

public interface TurnoService {


        List<Turno> listar();

        Turno buscarPorId(Long id);

        Turno crear(Turno turno);

        Turno actualizar( Long id,Turno turno);

        boolean cancelar(Long id);
    }

