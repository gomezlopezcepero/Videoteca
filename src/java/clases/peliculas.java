/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author asus
 */
public class peliculas {
    
    private String pelicula;
    private String director;
    private String fecha;

    public peliculas(String pelicula, String director, String fecha) {
        this.pelicula = pelicula;
        this.director = director;
        this.fecha = fecha;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  
    
    
    
}
