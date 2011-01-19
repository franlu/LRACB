/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Francisco Javier Lucena Lucena
 */
class Jugador {

    private String nombre;
    private String dniPass;
    private Calendar fechaNac;
    private double altura;
    private String posicion;
    private double peso;
    private String nacionalidad;
    private int numero;
    
    private Club club;

    //int numjornada, para agilizar busqueda de jornadas
    private Map<int,ClasificacionJugador> clasificacionJugador = new HashMap<int,ClasificacionJugador>();

    Jugador(String dniPas, String nombre, Calendar fechaNac, double altura, 
            double peso, String posicion, String nacionalidad , int numero,
            Club cl){}
    
    //No aparece en DCD pero si en DCol
    ArrayList evolucionJugador(){
    
        ArrayList resultado = new ArrayList();
        
        resultado.add(this.nombre);
        String nombClub = (this.club).getNombre();
        resultado.add(nombClub);
        resultado.add(this.posicion);
        
        if ((this.clasificacionJugador).size() == 0) {

            resultado.add("El jugador no ha participado en ninguna jornada");

        }
        else {
            // ordenar el map por la clave..
             //(this.clasificacionJugador).
             ArrayList datosJornada = new ArrayList();
             ClasificacionJugador clj;
             Iterator it = (this.clasificacionJugador).entrySet().iterator();

                while (it.hasNext()) {// Ojo con los casting
                    Map.Entry e = (Map.Entry)it.next();
                    clj = (ClasificacionJugador) e.getValue();
                    datosJornada = clj.obtenerDatosJornada();
                    resultado.add(datosJornada);
                }


        }

        return resultado;    
    
    }
    int obtenerNumero(){

        return this.numero;

    }
    
    //String obtenerNombre(){}
    String getNombre(){

        return this.nombre;

    }
    String obtenerPosicion(){}

    ArrayList obtenerDatosJugador(){
    
        ArrayList resultado = new ArrayList();
        
            resultado.add(this.nombre);
            //variante: devolver edad 
            resultado.add(this.fechaNac);
            resultado.add(this.altura);
            resultado.add(this.peso);
            resultado.add(this.posicion);
            resultado.add(this.nacionalidad);
            resultado.add(this.numero);
            
       return resultado;    
    
    }

    String obtenerNombClub(){}
    private void ordenarPorJornada(){}
    ArrayList obtenerClasificacion(){}
    ArrayList obtenerResultados(){}
    ClasificacionJugador obtenerUltima(){}
    void incluir(ClasificacionJugador cc){}
}