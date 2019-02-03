<%-- 
    Document   : consultarPelicula
    Created on : 10-nov-2016, 12:13:40
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
        <h1 style="color: blue;">Consultar una película</h1>
        
        <p>Seleccione la película a consultar:</p>
       
         <%
            
            BdAdministrador libros = new BdAdministrador();
            
            
            libros.abrirConexion();
       
            
           int cantidad=0;

            %>
        
            <form action="verPelicula.jsp" method="post">
            
                
                
         <select name="selec">
             <% for(int i=0;i<libros.hacerConsulta().size();i++){
             
            String dato= libros.hacerConsulta().get(i);
             %>
             <option><%=dato
           
                 %></option><%}
             
             libros.cerrarConexion();
             %>          
        </select>
        
        <input type="submit" value="ver detalle"/>
        
  </form>   
        
        
    </body>
</html>
