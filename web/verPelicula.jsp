<%-- 
    Document   : verPelicula
    Created on : 10-nov-2016, 12:20:48
    Author     : asus
--%>

<%@page import="clases.BdAdministrador"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
                <%
            
        BdAdministrador libros = new BdAdministrador();
        
        String peli=request.getParameter("selec");

        libros.abrirConexion();
        

      
       
%>
<h1 style="color: blue;">Consultar una película</h1>
<br>
<% for(int i=0;i<libros.consultaVariasTablas().size();i++){
    if(libros.consultaVariasTablas().get(i).getPelicula().equals(peli)){
        
    %>
    <p style="font-size: 18px;">Nombre <%=libros.consultaVariasTablas().get(i).getPelicula() %></p>
        <p style="font-size: 18px;">Director <%=libros.consultaVariasTablas().get(i).getDirector() %></p>
        <p style="font-size: 18px;">Fecha <%=libros.consultaVariasTablas().get(i).getFecha() %></p>

<%} } %>
        <br>
        
        <a href="index.html">volver a la página principal</a>

    </body>
</html>
