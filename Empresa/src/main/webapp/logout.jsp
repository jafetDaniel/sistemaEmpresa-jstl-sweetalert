<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate(); //cerrar sesion
    response.sendRedirect("login.jsp");
%>