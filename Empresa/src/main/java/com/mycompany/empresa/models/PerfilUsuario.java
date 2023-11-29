package com.mycompany.empresa.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="perfil_usuario")
public class PerfilUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_perfil;
    
    @OneToMany(mappedBy = "perfilUsuario")
    private List<Usuario> listaUsuarios; //1 estatus -> usuarios

    public PerfilUsuario() {
    }

    public PerfilUsuario(int id, String nombre_perfil) {
        this.id = id;
        this.nombre_perfil = nombre_perfil;
    }

    public PerfilUsuario(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }
    

}
