package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Estatus;

import com.mycompany.empresa.persistence.EstatusJpaController;
import java.util.List;

public class EstatusServiceImpl implements IEstatusService{
    EstatusJpaController estatusJPA = new  EstatusJpaController();
    

    @Override
    public List<Estatus> getEstatus() {
        return estatusJPA.findEstatusEntities();
    }
    
        @Override
    public Estatus traerEstatus(int id) {
        return estatusJPA.findEstatus(id);
    }

}
