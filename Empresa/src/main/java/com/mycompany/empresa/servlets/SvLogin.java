package com.mycompany.empresa.servlets;

import com.mycompany.empresa.models.Estatus;
import com.mycompany.empresa.models.Usuario;
import com.mycompany.empresa.service.EstatusServiceImpl;
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


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
     UsuarioServiceImpl control_usu = new UsuarioServiceImpl();
     EstatusServiceImpl control_estatus = new EstatusServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSession = request.getSession(true);
       
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String string_contador = (request.getParameter("contador"));
        int contador;
        
        if (string_contador.equals("")) {
             contador=5;
        }else{
             contador = Integer.parseInt(string_contador);
        }
        
        Usuario validacion = control_usu.comprobarIngreso(usuario, password);
        
        if (validacion != null && validacion.getEstatus().getNombre_estatus().equalsIgnoreCase("activo")) {
            miSession.setAttribute("user_session", validacion);
            response.sendRedirect("bienvenido.jsp");   
            
        }else{
            if (!usuario.equals("")) {
                List<Usuario> listaUsuarios = new ArrayList();
                listaUsuarios = control_usu.getUsuarios();

                for (Usuario u : listaUsuarios) {//buscar nombre de usuario
                    if (u.getAcceso().getUsuario().equals(usuario)) {//si el nombre de usuario es correcto
                        contador--; //restar intentos
                       
                        if (contador <= 0) {//si se realizaron 5 intentos
                            List<Estatus> listaEstatus = new ArrayList<>();
                            listaEstatus = control_estatus.getEstatus();

                            for (Estatus estatus : listaEstatus) {//buscar estatus suspendido
                                if (estatus.getNombre_estatus().equalsIgnoreCase("suspendido")) {//obtener campos del estatus suspendido
                                    Estatus est = estatus;
                                    u.setEstatus(est);
                                    control_usu.editarUsuario(u); //cambiar estatus en BD
                                }
                            }
                        }
                        if (u.getEstatus().getNombre_estatus().equalsIgnoreCase("suspendido")) {//si el estatus es suspendido
                            contador=0;
                        }
                        miSession.setAttribute("contador", Integer.toString(contador));
                    }
                }
            }
            response.sendRedirect("SvLogin");
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
