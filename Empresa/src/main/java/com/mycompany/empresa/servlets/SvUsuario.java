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


@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
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
        
        List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = control_usu.getUsuarios();
        
        List<PerfilUsuario> listaPerfil = new ArrayList<>();
        listaPerfil = control_perfil.getPerfilUsuarios();
        
        List<Estatus> listaEstatus = new ArrayList<>();
        listaEstatus = control_estatus.getEstatus();
        
        Usuario usu = new Usuario();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("titulo", "Registrar");
        miSesion.setAttribute("ruta", "SvUsuario");
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
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Acceso acceso = new Acceso(usuario, password);        
        control_acceso.crearAcceso(acceso);//crear acceso en bd
        
        int  id_estatus  = Integer.parseInt(request.getParameter("estatus"));
        int  id_perfilUsuario  = Integer.parseInt(request.getParameter("perfilUsuario"));
      
        Estatus estatus = control_estatus.traerEstatus(id_estatus);
        PerfilUsuario perfilUsuario = control_perfil.traerPerfilUsuario(id_perfilUsuario);

        Usuario usu = new Usuario(nombre,apellido_paterno,apellido_materno,correo,telefono,perfilUsuario,estatus,acceso);
       
        control_usu.crearUsuario(usu); //creando usuario
        
        response.sendRedirect("SvUsuario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
