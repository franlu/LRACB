/*
* Jugador
*
* Informacion de la version
*
* Fecha
*
* Copyright
*/
package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
    //TreeMap ordena en funcion de la key
    private Map<Integer,ClasificacionJugador> clasificacionJugador = new TreeMap<Integer,ClasificacionJugador>();


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
             //(this.clasificacionJugador). //ordenarPorJornada();
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
    String obtenerPosicion(){

        return (this.posicion);

    }

    String obtenerNombre(){

        return this.nombre;

    }

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

    String obtenerNombClub(){
    
        return (this.club).getNombre();
    
    }

    //Desaparece este metodo gracias a la clase TreeMap
    //private void ordenarPorJornada(){
    //}
    
    ArrayList obtenerClasificacion(){

        ArrayList resultadosUltimaClasificacion = new ArrayList();
        ClasificacionJugador ultimaClasificacion;

            if ((this.clasificacionJugador).size() != 0) {

                ultimaClasificacion = obtenerUltima();
                resultadosUltimaClasificacion = ultimaClasificacion.obtenerDatosClasificacion();
            }
            else {

                //resultadosUltimaClasificacion = devolver [0,0,0,0]

            }

        return resultadosUltimaClasificacion;

    }
    
    ArrayList obtenerResultados(){

        ArrayList resultado = new ArrayList();

        return resultado;

    }
    
    ClasificacionJugador obtenerUltima(){

        ClasificacionJugador clj = null;
        Iterator it = (this.clasificacionJugador).entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                clj = (ClasificacionJugador) e.getValue();

            }
        return clj;

    }
    
    void incluir(ClasificacionJugador cj){



    }
}