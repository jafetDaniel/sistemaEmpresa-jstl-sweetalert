<%@page import="com.mycompany.empresa.servlets.SvLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <%String contador = (String) request.getSession().getAttribute("contador");
          if (contador != null){ if (Integer.parseInt(contador) <=0){ %> 
            <script type="text/javascript"> Swal.fire({ icon: "error", title: "Oops...", text: "Usuario suspendido, favor de contactar al departamento de T.I."});</script>
        <%}}%>
        <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenido</h1>
                                    </div>
                                    <form class="user" action="SvLogin" method="post" id="form">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   id="usuario" name="usuario" placeholder="usuario">
                                        </div>
                                        <div class="form-group" style="margin-top: 10px">
                                            <input type="password" class="form-control form-control-user"
                                                   id="password" name="password" placeholder="password">
                                        </div>
                                        <input type="hidden" id="contador" name="contador" type="number" value="${contador}" readonly="">
                                        <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-top: 10px">Iniciar Sesion</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
     <script type="text/javascript">
        $("#form").submit(function (e) { //si se presiono el boton
            e.preventDefault();//detener el envio de form
            
            let usuario = $("#usuario").val();
            let password = $("#password").val();

            if (usuario === "" || password === "") {
                Swal.fire({ icon: "error", title: "", text: "Faltan datos por ingresar"});
            }else{
                document.getElementById("form").submit();       
            }
        });
    </script>
</html>