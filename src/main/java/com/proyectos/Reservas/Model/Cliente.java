package com.proyectos.Reservas.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @Column(nullable = false)
    private String nombre;

    @JsonProperty("email")
    @Column(name = "email" ,nullable = false)
    private String email;

    @Column(name = "activo")
    @Enumerated(EnumType.STRING)
    private Activo actvo;

    @OneToMany(mappedBy = "cliente")
    private List<Turno> turnos;


    public Cliente(Long cliente_id, String nombre, String correo, Activo actvo) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.email = correo;
        this.actvo = actvo;
    }
    public Cliente(){

    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public Activo getActvo() {
        return actvo;
    }

    public void setActvo(Activo actvo) {
        this.actvo = actvo;
    }
}
