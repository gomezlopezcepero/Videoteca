<%-- 
    Document   : insertar
    Created on : 10-nov-2016, 12:40:14
    Author     : asus
--%>

<%@page import="clases.Fecha"%>
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
      
            // PAGINA JSP QUE RECOGE LOS VALORES DEL FORMULARIO E INSERTA/ACTUALIZA LA BDD 
            
        try{
            
          String titulo=  request.getParameter("titulo");  
          String selec=  request.getParameter("selec");
          String fecha=  request.getParameter("fecha");

            if(titulo.equals("")||fecha.equals("")){
                %> <jsp:forward page="/insertar2.jsp"/> <%
            }
            BdAdministrador user = new BdAdministrador();
            
        //    Fecha fech = new Fecha(fecha);
            
            user.abrirConexion();
            
          String num=  user.consultarNumDirector(selec);
          
         int numd= Integer.parseInt(num);
          
            user.insertarRegistro(titulo,selec,fecha,numd);
            
      %>
      
      <p>Se ha insertado un nuevo registro</p>
      
      <a href="index.html">volver al inicio</a>
      
      <%
            }
            catch(Exception e){
             %> <jsp:forward page="/insertar2.jsp"/> <%
            }
        %>
        
        
    </body>
</html>
