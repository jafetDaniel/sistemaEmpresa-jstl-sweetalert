package com.mycompany.empresa.service;


import com.mycompany.empresa.models.PerfilUsuario;

import com.mycompany.empresa.persistence.PerfilUsuarioJpaController;

import java.util.List;

public class PerfilUsuarioServiceImpl implements IPerfilUsuarioService{
    PerfilUsuarioJpaController perfilJPA = new  PerfilUsuarioJpaController();
    

    @Override
    public List<PerfilUsuario> getPerfilUsuarios() {
        return perfilJPA.findPerfilUsuarioEntities();
    }
    
    
    @Override
    public PerfilUsuario traerPerfilUsuario(int id) {
        return perfilJPA.findPerfilUsuario(id);
    }
    

}
