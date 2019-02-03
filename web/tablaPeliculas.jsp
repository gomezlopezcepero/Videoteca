<%-- 
    Document   : tablaPeliculas
    Created on : 10-nov-2016, 11:52:28
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
     
        <%    BdAdministrador libros = new BdAdministrador();
    
    libros.abrirConexion();

    
    %>
        
    
    <h1 style="color: blue;">Lista de películas</h1>
        <table border="1">
            <thead>
                <tr style="background-color: blue; color: white;">
                    <th>Película</th>
                    <th>Director</th>
                    <th>Fecha</th>
                </tr>
            </thead>
            <tbody  style="background-color: cornflowerblue; color: white;">
                <% for(int i=0;i<libros.consultaVariasTablas().size() ;i++){%>
                 <tr>
                     <td><%=libros.consultaVariasTablas().get(i).getPelicula()  %></td>
                     <td><%=libros.consultaVariasTablas().get(i).getDirector()%></td>
                     <td><%=libros.consultaVariasTablas().get(i).getFecha() %></td>
                </tr>
              <% }%>
            </tbody>
        </table>
            <br>
            
            <a href="index.html">volver a la página principal</a>
        
        
    </body>
</html>
