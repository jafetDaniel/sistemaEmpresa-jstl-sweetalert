<%@page import="com.mycompany.empresa.service.UsuarioServiceImpl"%>
<%@page import="com.mycompany.empresa.models.Usuario"%>
<%@page import="com.mycompany.empresa.models.Estatus"%>
<%@page import="com.mycompany.empresa.service.EstatusServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.empresa.models.PerfilUsuario"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.empresa.service.PerfilUsuarioServiceImpl"%>
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
        <title>Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <%@ include file="/WEB-INF/menuOpciones.jspf"%>
        <div class="container-fluid p-4">
            <h1>Gestión de usuarios</h1>
            <div class="row">
                
                <div class="card col-md-4">
                <div class="card-body">
                    
                    <div style="display:flex;">
                        <h5 class="card-title" style="margin-right:10px;">${titulo} usuario</h5>
                        <c:if test="${titulo == 'Modificar'}">
                            <a type="button" class="btn btn-primary btn-sm" href="SvUsuario">Nuevo (Limpiar campos)</a>
                        </c:if>
                    </div>
                    
                    <form action="${ruta}" method="post" id="form">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input name="nombre" type="text" class="form-control" id="nombre" value="${usu_form.nombre}">
                        </div>

                        <div class="mb-3">
                            <label for="apellido_paterno" class="form-label">Apellido paterno</label>
                            <input name="apellido_paterno" type="text" class="form-control" id="apellido_paterno" value="${usu_form.apellido_paterno}">
                        </div>

                        <div class="mb-3">
                            <label for="apellido_materno" class="form-label">Apellido Materno</label>
                            <input name="apellido_materno" type="text" class="form-control" id="apellido_materno" value="${usu_form.apellido_materno}">
                        </div>

                        <div class="mb-3">
                            <label for="correo" class="form-label">Correo</label>
                            <input name="correo" type="email" class="form-control" id="correo" value="${usu_form.correo}">
                        </div>

                        <div class="mb-3">
                            <label for="telefono" class="form-label">Teléfono</label>
                            <input name="telefono" type="number" class="form-control" id="telefono" value="${usu_form.telefono}">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Perfil usuario</label>

                            <select class="form-control" name="perfilUsuario" id="perfilUsuario" style="width: 300px">
                                <c:choose>
                                    <c:when test="${titulo == 'Registrar'}">
                                        <option value="0">seleccione perfil</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${usu_form.perfilUsuario.id}">${usu_form.perfilUsuario.nombre_perfil}</option>
                                    </c:otherwise>
                                </c:choose> 
                                <c:forEach var="per" items="${listaPerfil}"> 
                                <option value="${per.id}">${per.nombre_perfil}</option>
                               </c:forEach>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Estatus</label>

                            <select class="form-control" name="estatus" id="estatus" style="width: 300px">
                                <c:choose>
                                    <c:when test="${titulo == 'Registrar'}">
                                        <option value="0">seleccione estatus</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${usu_form.estatus.id}">${usu_form.estatus.nombre_estatus}</option>
                                    </c:otherwise>
                                </c:choose>  
                                <c:forEach var="es" items="${listaEstatus}"> 
                                <option value="${es.id}">${es.nombre_estatus}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="usuario" class="form-label">Usuario</label>
                            <input name="usuario" type="text" class="form-control" id="usuario" value="${usu_form.acceso.usuario}">
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input name="password" type="password" class="form-control" id="password" value="${usu_form.acceso.password}">
                            <div class="form-text">Mínimos 8 Caracteres, Una letra Mayúscula, Un número</div>
                        </div>

                        <button type="submit" class="btn btn-primary">${titulo}</button>
                    </form>
                </div>
            </div>
                            
            <!-- DataTales Example -->
            <div class="col-md-8">
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
                                    <th style="width: 210px;">Acción</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="usu" items="${listaUsuarios}">       
                                <tr>
                                    <td>${usu.id}</td>
                                    <td>${usu.nombre}</td>
                                    <td>${usu.apellido_paterno}</td>
                                    <td>${usu.apellido_materno}</td>
                                    <td>${usu.correo}</td>
                                    <td>${usu.telefono}</td>
                                    <td>${usu.perfilUsuario.nombre_perfil}</td>
                                    <td>${usu.estatus.nombre_estatus}</td>
                                    <td>${usu.acceso.usuario}</td>

                                    <td style="display:flex; width:230px;">
                                        <div style="margin-left: 5px;">
                                            <form name="editar" id="editar" action="SvEditUsuario" method="get">
                                                <button type="submit" class="btn btn-success">
                                                    <i class="fas fa-pencil-alt"></i>
                                                    Editar
                                                </button>
                                                <input type="hidden" name="id_edit" value="${usu.id}">
                                            </form>
                                        </div> 
                                    </td>
                                </tr>
                                 </c:forEach>
                            </tbody>
                        </table>
                    </div>
            </div>                 
            </div><!-- row -->
        </div><!-- container-->
    </body>
    <script type="text/javascript">
        $("#form").submit(function (e) { //si se presiono el boton
            e.preventDefault();//detener el envio de form
            
            let nombre = $("#nombre").val();
            let apellido_paterno = $("#apellido_paterno").val();
            let apellido_materno = $("#apellido_materno").val();
            let correo = $("#correo").val();
            let telefono = $("#telefono").val();
            let usuario = $("#usuario").val();
            let password = $("#password").val();

            let perfilUsuario = $("#perfilUsuario").val();
            let estatus = $("#estatus").val();

            if (nombre === "" || apellido_paterno === "" || apellido_materno === "" ||
                    correo === "" || telefono === "" || usuario === "" || password === "" ||
                    estatus === "0" || perfilUsuario === "0") {
                
                Swal.fire({ icon: "error", title: "Oops...", text: "Faltan datos por ingresar"});
            }else{
                
               Swal.fire({
                         title: "¿Estás seguro de registrar al usuario?",
                         showCancelButton: true,
                         confirmButtonText: "Registrar"
                         })
                    .then((result) => {          
                        if (result.isConfirmed) {  
                            Swal.fire({
                                          icon: "success",
                                          title: "Usuario registrado correctamente",
                                          showConfirmButton: false,
                                          timer: 1500
                                        });
                            setTimeout(function() {document.getElementById("form").submit(); }, 1500);
                        }
                    });
            }
        });
    </script>
</html>
