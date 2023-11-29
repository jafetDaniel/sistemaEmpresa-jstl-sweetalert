package com.mycompany.empresa.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name = "id_perfil_usuario")
    private PerfilUsuario perfilUsuario;//n usuarios -> 1 perfil
     
    @ManyToOne
    @JoinColumn(name = "id_estatus")
    private Estatus estatus; //n usuarios -> 1 estatus
    
    @OneToOne
    private Acceso acceso; //1 usuario -> 1 acceso
    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido_paterno, String apellido_materno, String correo, String telefono, PerfilUsuario perfilUsuario, Estatus estatus, Acceso acceso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.telefono = telefono;
        this.perfilUsuario = perfilUsuario;
        this.estatus = estatus;
        this.acceso = acceso;
    }

    public Usuario(String nombre, String apellido_paterno, String apellido_materno, String correo, String telefono, PerfilUsuario perfilUsuario, Estatus estatus, Acceso acceso) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.telefono = telefono;
        this.perfilUsuario = perfilUsuario;
        this.estatus = estatus;
        this.acceso = acceso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
    
    

 
}
