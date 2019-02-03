/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author DAW
 */
public class Fecha implements Comparable<Fecha> {
    
    private Calendar fecha;
    private int dia, mes, ano;

    public Fecha() {
        
        fecha=GregorianCalendar.getInstance(Locale.getDefault());
    }
    
    public Fecha(String date)throws FechaIncorrecta {
        
        if(!isFechaValida(date))
            throw new FechaIncorrecta("Introduzca una fecha valida");
        this.setFecha(date);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(String date) {
        String[] arrayFecha=date.split("-");
        this.fecha=new GregorianCalendar(Integer.parseInt(arrayFecha[2]),Integer.parseInt(arrayFecha[1])-1,Integer.parseInt(arrayFecha[0]));
        this.setAno(); this.setMes(); this.getDia();
    }

    public int getDia() {
        return dia;
    }

    public void setDia() {
        
        this.dia = this.fecha.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
        return mes+1;
    }

    public void setMes() {
        this.mes = this.fecha.get((Calendar.MONTH));
    }

    public int getAno() {
        return ano;
    }

    public void setAno() {
        this.ano = this.fecha.get(Calendar.YEAR);
    }
    
//    Los sets se usan como metodos que alteran los propios atributos dentro de la misma clase
//            sin entrar en contacto con el main, los constructores deben tener sets y no atributos normales
//                    para que estos puedan alterarlos
    
    public void agregarDias(int dias){
        this.fecha.add(Calendar.DAY_OF_MONTH, dias);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fecha other = (Fecha) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha.getTime());
        
    }
    
    private static boolean isFechaValida(String fecha){
        
    try{
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    formatoFecha.setLenient(false);
    formatoFecha.parse(fecha);
    } catch(ParseException e){
        return false;
    }
    return true;
    
    }

    public int compareTo(Fecha f) {
        Fecha fecha=(Fecha)f;
        return this.fecha.compareTo(f.fecha);
    }
    
    class FechaIncorrecta extends Exception{
        
        public FechaIncorrecta(String string){
            super(string);
        }
    }
    
    
    
    
}
