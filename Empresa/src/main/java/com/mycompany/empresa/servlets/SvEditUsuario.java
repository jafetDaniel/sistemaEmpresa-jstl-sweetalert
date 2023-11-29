package com.mycompany.empresa.servlets;

import com.mycompany.empresa.models.Acceso;
import com.mycompany.empresa.models.Estatus;
import com.mycompany.empresa.models.PerfilUsuario;
import com.mycompany.empresa.models.Usuario;
import com.mycompany.empresa.service.AccesoServiceImpl;
import com.mycompany.empresa.service.EstatusServiceImpl;
import com.mycompany.empresa.service.PerfilUsuarioServiceImpl;
import com.mycompany.empresa.service.UsuarioServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditUsuario", urlPatterns = {"/SvEditUsuario"})
public class SvEditUsuario extends HttpServlet {
    UsuarioServiceImpl control_usu = new UsuarioServiceImpl();
    AccesoServiceImpl control_acceso = new AccesoServiceImpl();
    EstatusServiceImpl control_estatus = new EstatusServiceImpl();
    PerfilUsuarioServiceImpl control_perfil = new PerfilUsuarioServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id_edit")); //obetener id del form
        Usuario usu = control_usu.traerUsuario(id); //obtener datos del usuario de la bd
        
        List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = control_usu.getUsuarios();
        
        List<PerfilUsuario> listaPerfil = new ArrayList<PerfilUsuario>();
        listaPerfil = control_perfil.getPerfilUsuarios();
        
        List<Estatus> listaEstatus = new ArrayList<Estatus>();
        listaEstatus = control_estatus.getEstatus();

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("titulo", "Modificar");
        miSesion.setAttribute("ruta", "SvEditUsuario");
        miSesion.setAttribute("usu_form", usu);
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        miSesion.setAttribute("listaPerfil", listaPerfil);
        miSesion.setAttribute("listaEstatus", listaEstatus);
        
        response.sendRedirect("altaModificaUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        
        int  id_estatus  = Integer.parseInt(request.getParameter("estatus"));
        int  id_perfilUsuario  = Integer.parseInt(request.getParameter("perfilUsuario"));
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Estatus estatus = control_estatus.traerEstatus(id_estatus);
        PerfilUsuario perfilUsuario = control_perfil.traerPerfilUsuario(id_perfilUsuario);

        Usuario usu = (Usuario) request.getSession().getAttribute("usu_form"); //obteniedo datos anteriores     
        Acceso acceso = usu.getAcceso();
        
        acceso.setUsuario(usuario);
        acceso.setPassword(password);
        control_acceso.editarAcceso(acceso);//edit acceso in BD
        
        usu.setNombre(nombre); //cambiando valores de la variable de sesion
        usu.setApellido_paterno(apellido_paterno);
        usu.setApellido_materno(apellido_materno);
        usu.setCorreo(correo);
        usu.setTelefono(telefono);
        usu.setPerfilUsuario(perfilUsuario);
        usu.setEstatus(estatus);
        usu.setAcceso(acceso);        
        control_usu.editarUsuario(usu); //edit user in BD
        
        response.sendRedirect("SvUsuario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
