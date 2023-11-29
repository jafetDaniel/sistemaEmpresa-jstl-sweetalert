package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Usuario;
import com.mycompany.empresa.persistence.UsuarioJpaController;
import com.mycompany.empresa.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioServiceImpl implements IUsuarioService{
    UsuarioJpaController usuJPA = new UsuarioJpaController(); 
     
    @Override
     public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }
     
    @Override
    public List<Usuario> getUsuarios() {
        return usuJPA.findUsuarioEntities();
    }
    
    @Override
    public void borrarUsuario(int id) {
        
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }
    
    @Override
    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Usuario comprobarIngreso(String nombre, String password) { //para login
        
         Usuario ingreso = null;
         
         List <Usuario> listaUsuarios = new ArrayList<Usuario>();
         listaUsuarios = this.getUsuarios();
         
         for (Usuario usu : listaUsuarios) {
             if (usu.getAcceso().getUsuario().equals(nombre) ) {
                 if (usu.getAcceso().getPassword().equals(password)) {
                     ingreso = usu;
                     break;
                 }
             }
         }
         return ingreso;
    }
    
    
}
