package com.proyectos.Reservas.Service;

import com.proyectos.Reservas.Model.Activo;
import com.proyectos.Reservas.Model.Servicio;
import com.proyectos.Reservas.Repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements  ServicioService{

    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository1){
        this.servicioRepository = servicioRepository1;
    }


    @Override
    public Servicio buscarId(Long id) {
        return  servicioRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio crear(Servicio servicio) {
       servicio.setActivo(Activo.ACTIVO);
       return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizar(Long id, Servicio servicio) {
      if (servicio.getServicio_id() == null){
          throw new RuntimeException("El id del servicio es obligatorio");

      }

      Servicio d = servicioRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

      d.setNombre(servicio.getNombre());
      d.setPrecio(servicio.getPrecio());
      d.setDuracionMinutos(servicio.getDuracionMinutos());
      d.setActivo(servicio.getActivo());

      return servicioRepository.save(d);
    }

    @Override
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @Override
    public Boolean desactivarServicio(Long id) {
        Optional<Servicio> d = servicioRepository.findById(id);

        if (d.isEmpty()){
            return false;
        }

        Servicio servicio = d.get();
        servicio.setActivo(Activo.DESACTIVO);
        servicioRepository.save(servicio);
       return true;
    }
}
