package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Estatus;
import java.util.List;

public interface IEstatusService {
    
    public Estatus traerEstatus(int id);
    public List<Estatus> getEstatus();
}
