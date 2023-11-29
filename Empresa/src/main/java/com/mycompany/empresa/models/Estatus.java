package com.mycompany.empresa.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre_estatus;
    
    @OneToMany(mappedBy = "estatus")
    private List<Usuario> listaUsuarios; //1 estatus -> usuarios

    public Estatus() {
    }

    public Estatus(int id, String nombre_estatus) {
        this.id = id;
        this.nombre_estatus = nombre_estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_estatus() {
        return nombre_estatus;
    }

    public void setNombre_estatus(String nombre_estatus) {
        this.nombre_estatus = nombre_estatus;
    }

    
    
}
