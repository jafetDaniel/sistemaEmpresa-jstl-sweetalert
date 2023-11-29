<%@page import="com.mycompany.empresa.models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Usuario user_session = (Usuario) request.getSession().getAttribute("user_session"); //obtener valor de la sesion
    if (user_session == null) {
            response.sendRedirect("login.jsp");
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@ include file="/WEB-INF/menuOpciones.jspf"%>
        <%Usuario usu = (Usuario) request.getSession().getAttribute("user_session");%>
        
        <div class="container">
         <h1>Bienvenido a tu Empresa</h1>
         
          <!-- DataTales Example -->
            <div class="card shadow mb-4" style="margin-top:50px;">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Usuario: <%=usu.getNombre()%></h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Apellido paterno</th>
                                    <th>Apellido materno</th>
                                    <th>Correo</th>
                                    <th>Telefono</th>
                                    <th>Perfil usuario</th>
                                    <th>Estatus</th>
                                    <th>usuario</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td><%=usu.getId()%></td>
                                    <td><%=usu.getNombre()%></td>
                                    <td><%=usu.getApellido_paterno()%></td>
                                    <td><%=usu.getApellido_materno()%></td>
                                    <td><%=usu.getCorreo()%></td>
                                    <td><%=usu.getTelefono()%></td>
                                    <td><%=usu.getPerfilUsuario().getNombre_perfil()%></td>
                                    <td><%=usu.getEstatus().getNombre_estatus()%></td>
                                    <td><%=usu.getAcceso().getUsuario()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                            
        </div>                  
    </body>
</html>
