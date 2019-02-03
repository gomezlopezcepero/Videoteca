/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class despachar extends HttpServlet {

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

             RequestDispatcher rd = null;
         ServletContext contexto=getServletContext();
            
            
             
           
            
            
            
            String usuario=request.getParameter("usuario");
            String contra=request.getParameter("contra");
       
       contexto.setAttribute("usuario", usuario);
       contexto.setAttribute("contra", contra);

       BdAdministrador comprobar = new BdAdministrador();
       
       comprobar.abrirConexion();
       
      boolean bulean= comprobar.comprobarExistencia(usuario, contra);
      
     
       if(bulean==true){
         
               
               rd=contexto.getRequestDispatcher("/formularioAlta.jsp");
       
                 rd.forward(request, response);
               
           }
            else{

           rd=contexto.getRequestDispatcher("/insertar2.jsp");
       
       rd.forward(request, response);
           
       }

           
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(despachar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}