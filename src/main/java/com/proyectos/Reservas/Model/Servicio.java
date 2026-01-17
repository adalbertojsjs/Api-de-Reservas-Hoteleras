package com.proyectos.Reservas.Model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long servicio_id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer  duracionMinutos; //  duracionMinutos;

    @Column(nullable = false)
    private Double precio;

    @Enumerated(EnumType.STRING)
    private Activo activo;

    @OneToMany(mappedBy = "servicio")
    private List<Turno> lista;


    public Servicio(Long servicio_id, String nombre, Integer duracionMinutos, Double precio, Activo activo) {
        this.servicio_id = servicio_id;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
        this.activo = activo;
    }

    public Servicio(){

    }

    public Long getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Long servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }
}
