package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Acceso;
import java.util.List;

public interface IAccesoService {
  
    public void crearAcceso(Acceso acceso);
    public Acceso traerAcceso(int id);
    public List<Acceso> getAccesos();
    public void editarAcceso(Acceso acceso);
}
