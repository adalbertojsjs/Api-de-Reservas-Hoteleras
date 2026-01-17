package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Cliente;
import com.proyectos.Reservas.Model.Estado;
import com.proyectos.Reservas.Model.Servicio;
import com.proyectos.Reservas.Model.Turno;
import com.proyectos.Reservas.Repository.ClienteRepository;
import com.proyectos.Reservas.Repository.ServicioRepository;
import com.proyectos.Reservas.Repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class TurnoServiceImpl implements TurnoService{

    private  final TurnoRepository repository;
    private  final ClienteRepository clienteRepository;
    private final ServicioRepository servicioRepository;

    public TurnoServiceImpl(TurnoRepository repository, ClienteRepository clienteRepository,
                            ServicioRepository servicioRepository){
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.servicioRepository = servicioRepository;
    }
    
    @Override
    public List<Turno> listar() {
        return repository.findAll();
    }

    @Override
    public Turno buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Turno crear(Turno turno) {
        Cliente cliente = clienteRepository
                .findById(turno.getCliente().getCliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        Servicio servicio = servicioRepository
                .findById(turno.getServicio().getServicio_id())
                .orElseThrow(() -> new RuntimeException("Servicio no existe"));

        turno.setCliente(cliente);
        turno.setServicio(servicio);


        return repository.save(turno);
    }

    @Override
    public Turno actualizar( Long id,Turno turno) {
        if (turno.getId_Turno() == null){
            throw new RuntimeException("El id es obligatorio");
        }

        Turno turno1 = repository.findById(turno.getId_Turno())
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));


        turno1.setFechaHoraInicio(turno.getFechaHoraInicio());
        turno1.setFechaHoraFin(turno.getFechaHoraFin());
        turno1.setEstado(turno.getEstado());

        return repository.save(turno1);
    }

    @Override
    public boolean cancelar(Long id) {
        Optional<Turno> existente = repository.findById(id);

        if (existente.isEmpty()){
            return false;

        }
        Turno turno = existente.get();
        turno.setEstado(Estado.CANCELADO);
        repository.save(turno);
        return true;

    }
}
