package com.mycompany.empresa.service;

import com.mycompany.empresa.models.PerfilUsuario;
import java.util.List;

public interface IPerfilUsuarioService {
    
    public PerfilUsuario traerPerfilUsuario(int id);
    public List<PerfilUsuario> getPerfilUsuarios();
}
