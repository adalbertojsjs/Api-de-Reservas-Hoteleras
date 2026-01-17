package com.proyectos.Reservas.Repository;

import com.proyectos.Reservas.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
