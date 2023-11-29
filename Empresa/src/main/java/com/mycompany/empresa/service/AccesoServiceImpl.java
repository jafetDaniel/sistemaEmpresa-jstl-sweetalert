package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Acceso;

import com.mycompany.empresa.persistence.AccesoJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoServiceImpl implements IAccesoService{
    AccesoJpaController accesoJPA = new  AccesoJpaController();
    
    @Override
     public void crearAcceso(Acceso acceso) {
        accesoJPA.create(acceso);
    }

    @Override
    public List<Acceso> getAccesos() {
        return accesoJPA.findAccesoEntities();
    }
    
    @Override
    public  Acceso traerAcceso(int id) {
        return accesoJPA.findAcceso(id);
    }
    
    @Override
    public void editarAcceso(Acceso acceso) {
        try {
            accesoJPA.edit(acceso);
        } catch (Exception ex) {
            Logger.getLogger(AccesoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
}
