package com.mycompany.empresa.service;

import com.mycompany.empresa.models.Usuario;
import java.util.List;


public interface IUsuarioService {
    
    public void crearUsuario(Usuario usu);
    public List<Usuario> getUsuarios();
    public Usuario traerUsuario(int id);
    public void editarUsuario(Usuario usu);
    public void borrarUsuario(int id);
    public Usuario comprobarIngreso(String nombre_usuario, String password);
}
