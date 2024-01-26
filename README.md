# sistemaEmpresa-jstl-sweetalert
Sistema web en java usando jstl, sweetalert, javaScript, jspf, servlets, jsp, jpa, Bootstrap

•   Crear el proyecto en NetBeans, Java web, Web Application con el nombre “Empresa” que debe de contener los siguientes archivos:

o   Login.jsp 
<ul>
    <li>Validación de acceso</li>
    <li>Más de 5 intentos se suspende el usuario, mostrando el mensaje: Usuario suspendido, favor de contactar al departamento de T.I.</li>
</ul>

o   AltaModificaUsuario.jsp

-Formulario de alta
<ul>
    <li>Nombre</li>
    <li>Apellido Paterno</li>
    <li>Apellido Materno</li>
    <li>Correo</li>
    <li>Teléfono</li>
    <li>Perfil usuario
        <ul>
            <li>Master</li>
            <li>Empleado</li>
        </ul>
    </li>
    <li>Estatus
        <ul>
            <li>(A) Activo.</li>
            <li>(S) Suspendido.</li>
        </ul>
    </li>
    <li>Usuario</li>
    <li>Password
        <ul>
            <li>Mínimos 8 Caracteres</li>
            <li>Una letra Mayúscula</li>
            <li>Un número</li>
        </ul>
        </li>
</ul>

- Deberá de validar los campos:
  <ul>
      <li>Si existe algún campo vació mostrar mensaje que faltan datos por ingresar.</li>
      <li>Si No existe campos vacíos Mostrar mensaje, estás seguro de registrar al usuario, deberá de contener dos botones:
          <ul>
              <li>Cancelar
                 <ul><li>Cierra el mensaje.</li></ul>
             </li>
              <li>Registrar
                  <ul><li>Deberá de registrar a la base de datos y mostrando el mensaje Usuario registrado correctamente.</li></ul>
              </li>
          </ul>
      </li>
      <li>En el mismo archivo se deberá de mostrar en una tabla con Bootstrap los usuarios creados, con los datos del formulario de Alta.</li>
      <li>Modificación de usuario, deberá de contener los mismos datos de alta y características.</li>
  </ul>

o   Bienvenido.jsp <br>
    -   Deberá de mostrar el texto “Bienvenido a tu empresa”, mostrando los datos del usuario ingresado en una tabla con Bootstrap.

o   MenuOpciones.jspf <br>
    -   Deberán de contener los archivos jsp

•   Crear base de datos en MySQL que se llame “Empresa” que debe de incluir las siguientes tablas: <br>
    o   Usuario <br>
    o   Acceso <br>
    o   PerfilUsuario <br>
        -   Master <br>
        -   Empleado <br>
    o   Estatus <br>
        -   Activo <br>
        -   Suspendido <br>

o   Todas las tablas deberán estar relacionadas.

o   Características de los Usuario <br>
    -   Master deberá poder: <br>
        •   Ingresar desde el archivo Login.jsp <br>
        •   MenuOpciones.jspf <br>
            -   Tener acceso a todos los archivos creados. <br>
            -   Podrá Crear y Modificar a los usuarios Empleados.  <br>
    -   Empleado  <br>
        •   Deberá ingresar desde el archivo Login.jsp <br>
        •   MenuOpciones.jspf <br>
            -   Tener acceso al archivo de Bienvenido.jsp <br>

•   Deberán usar: <br>
o   IDE Desarrollo NetBeans <br>
o   Bootstrap <br>
o   Sweetalert (Para todos los mensajes). <br>
o   JavaScript <br>
o   Servlet <br>
o   Java Interface <br>
o   Implements de Java Interface <br>

<img src="Empresa/src/main/webapp/img/empresa1.png">
<img src="Empresa/src/main/webapp/img/empresa2.png">
<img src="Empresa/src/main/webapp/img/empresa3.png">
<img src="Empresa/src/main/webapp/img/empresa4.png">
<img src="Empresa/src/main/webapp/img/empresa5.png">
<img src="Empresa/src/main/webapp/img/empresa6.png">
