/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author asus
 */
public class BdAdministrador {
    
    
    
	 String drv="com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/vidioteca";
      public ArrayList<peliculas> artis; //cambiar String por la clase que vayas a necesitar
       
	Connection cn = null; //conexiones
	Statement st; //consultas
	public ResultSet rs;
	public PreparedStatement psInsertar;
	public BdAdministrador(){
		super();
		
		
	}

	public void abrirConexion() {
		// TODO Auto-generated method stub
		
		
		try{
			
			Class.forName(drv);
			cn=(Connection) DriverManager.getConnection(url, "root", "");
			st=cn.createStatement();
		}
		catch(Exception e){
			
			System.out.println("No se pudo conectar con la base de datos");
			
		}
		
	}
	
	
	public void cerrarConexion() throws SQLException {
		
		//if(rs!=null) rs.close();
		
		if(cn!=null) cn.close();
		System.out.println("Conexión cerrada");
		
	}
        
        /*
       Borra los registros seleccionados con los checkbox, recibe un arraylist de la tabla entera hecha en crearTabla(), 
        el array valueof pasado a int y el array valueof string original
        
        */
        public void borrarRegistros(ArrayList<String> artis, int[] id, String[] veves) throws SQLException{
            
            for(int i=0;i<veves.length;i++){
                
                
                
         //       String borrar = "DELETE FROM usuarios where clave = '"+artis.get(id[i]).getClave()+"'";
           //           int rs2=st.executeUpdate(borrar);
                
            }
            
        }
        
        
        //hace un select de toda la tabla, saca sus valores y los mete en un arraylist, usalo para crear tablas
         public ArrayList<String> crearTabla() throws SQLException{
            
            String consulta = "SELECT * from usuarios";
            
            ArrayList<String> artis = new ArrayList();
            
            rs=st.executeQuery(consulta);
            
       
                        
            while(rs.next()){
                
               String usuario= rs.getString("usuario");
               String clave2= rs.getString("clave");
               String nombre= rs.getString("nombre");
               String direccion= rs.getString("direccion");
               String tipo= rs.getString("tipo");
               String email= rs.getString("email");
               
          //     usuarios user = new usuarios(usuario,clave2,tipo,nombre,direccion,email);
               
          //     artis.add(user);
               
            }
            
            return(artis);
            
        }
        
         /*
        Consulta varias tablas y saca sus registros, 
        */    
         
        public ArrayList<peliculas> consultaVariasTablas() throws SQLException{
                       
            
            String consulta = "SELECT peliculas.titulo, peliculas.fecha_estreno, director.nombre from peliculas, director where peliculas.director = director.id";
            ArrayList<peliculas> artis = new ArrayList<>();
            rs=st.executeQuery(consulta);
            while(rs.next()){
              String pelicula= rs.getString("titulo");
              
              String director= rs.getString("nombre");
              
              String fecha= rs.getString("fecha_estreno");
              
                      
               peliculas book = new peliculas(pelicula, director, fecha);
               
               artis.add(book);
               
            }
            
            return artis;
        }
        
        
        public ArrayList<String> hacerConsulta() throws SQLException{
                    
            String consulta = "SELECT peliculas.titulo from peliculas, director where peliculas.director = director.id";
           ArrayList<String> artis = new ArrayList<>();
            rs=st.executeQuery(consulta);
            
            
            while(rs.next()){
                artis.add(rs.getString("titulo"));
            }
            
            return artis;
            
        }
        
        
        
        public ArrayList<String> consultarDirector() throws SQLException{
                    
            String consulta = "SELECT nombre from director";
           ArrayList<String> artis = new ArrayList<>();
            rs=st.executeQuery(consulta);
            
            
            while(rs.next()){
                artis.add(rs.getString("nombre"));
            }
            
            return artis;
            
        }
        
        
        
        public String consultarNumDirector(String selec) throws SQLException{
                    
            String consulta = "SELECT peliculas.director from peliculas, director where peliculas.director = director.id and director.nombre = '"+selec+"'";
           ArrayList<String> artis = new ArrayList<>();
            rs=st.executeQuery(consulta);
            String num = "";
            
            while(rs.next()){
                num=rs.getString("director");
            }
            
            return num;
            
        }
        
        
        
        
        //hace un select de un registro en concreto, saca sus valores y los mete en un arraylist, usalo para rellenar un formulario de editar  
        public ArrayList<String> consultaUnRegistro(String clave) throws SQLException{
            
            String consulta = "SELECT * from usuarios where clave = '"+clave+"'";
            
            ArrayList<String> artis = new ArrayList();
            
            rs=st.executeQuery(consulta);
            
       
                        
            while(rs.next()){
                
               String usuario= rs.getString("usuario");
               String clave2= rs.getString("clave");
               String nombre= rs.getString("nombre");
               String direccion= rs.getString("direccion");
               String tipo= rs.getString("tipo");
               String email= rs.getString("email");
               
         //      usuarios user = new usuarios(usuario,clave,tipo,nombre,direccion,email);
               
         //      artis.add(user);
               
            }
            
            return(artis);
            
        }

        
        //comprueba la existencia del usuario, manda true si el nombre de usuario y contraseña se encuentra en la base de datos
        public boolean comprobarExistencia(String nombre, String clave) throws SQLException{
            
            String consulta = "SELECT * from usuario where usuario = '"+nombre+"' and password = '"+clave+"'";
                        
            rs=st.executeQuery(consulta);
            
            int cont=0; boolean bulean=false;
                        
            while(rs.next()){
                
                cont++;
            }
            
            if(cont==1){
                
                bulean = true;
                
            }
            
            return bulean;
        }
        
        //comprueba si el tipo del usuario es administrador o usuario, manda true a despachar si es administrador y false si es usuario
        public boolean comprobarTipo(String clave) throws SQLException{
            
            
            String consulta = "SELECT * from usuarios where clave = '"+clave+"'";
            String tipo2="";
                        
            rs=st.executeQuery(consulta);
            
            boolean bulean=false;
                        
            while(rs.next()){
                
                tipo2=  rs.getString("tipo");
               
            }
            
            if(tipo2.equals("administrador")){
                
                bulean = true;
                
            }
            
            return bulean;
            
            
        }
        
  
       //inserta un registro 
        public void insertarRegistro(String titulo, String director, String fecha, int num) throws SQLException{
            

            fecha= "'"+fecha+"'";
            
            String insertar="INSERT INTO peliculas (titulo, director, fecha_estreno) VALUES ('"+titulo+"', '"+num+"', "+fecha+")";
            
            int rs=st.executeUpdate(insertar);
            
     
            
        }
        
        
    public ArrayList<String> borrarYrecuperarLoBorrado() throws SQLException{
    
     String consulta = "SELECT * FROM ventaordenadores where Unidades > 60";
                    
                    ResultSet rs=st.executeQuery(consulta);

                    ArrayList<String> artis = new ArrayList();

                    
                 
                    
                //   System.out.println(contador);
                   
                    while(rs.next()){
                        
                 //       Trimestre=rs.getString("Trimestre");
                   //     Unidades=rs.getString("Unidades");
                     //   vendedores=rs.getString("Vendedores");
                     
                        
                    //         usuarios user = new usuarios(trimestre, unidades, vendedores);
               
                       //      artis.add(user);

                    //    cont++;
            }
                    
                     String borrar = "DELETE FROM ventaordenadores where Unidades > 60";
                      int rs2=st.executeUpdate(borrar);
    
                      return artis;
                      
}
        
}