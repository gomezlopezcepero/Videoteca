<%-- 
    Document   : formularioAlta
    Created on : 10-nov-2016, 12:30:14
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
            
            BdAdministrador admin = new BdAdministrador();
            
            admin.abrirConexion();
            
            RequestDispatcher rd = null;
         ServletContext contexto=getServletContext();
         
          Object usuario=  contexto.getAttribute("usuario");
      Object contra= contexto.getAttribute("contra");
            
     boolean bulean= admin.comprobarExistencia(usuario.toString(), contra.toString());
     if(bulean==true){
            %>
        
        <h1 style="color: blue;">Alta película</h1>
        
        <form action="insertar.jsp" method="POST">
        
        <table>
            <tr>  
                <th>Pelicula</th>
        <td><input type="text" name="titulo" value="" /></td>
            </tr>
            <tr>
                <th>Director</th>
                <td><select name="selec">
             <% for(int i=0;i<admin.consultarDirector().size();i++){
             
            String dato= admin.consultarDirector().get(i);
             %>
             <option><%=dato
           
                 %></option><%}
             
             admin.cerrarConexion();
             %>          
        </select></td>
            </tr>
            <tr>
                
                <th>Fecha</th>
                <td><input type="text" value="" name="fecha"/></td>
            </tr>

        </table>
        <br>
        <input type="submit" value="añadir película"/>
        </form>
        <% }else{
        %><jsp:forward page="/insertar2.jsp"/><%
    }%>
        
    </body>
</html>
