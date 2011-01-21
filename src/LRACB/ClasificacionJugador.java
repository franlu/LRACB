/*
* ClasificacionJugador
*
* Informacion de la version
*
* Fecha
*
* Copyright
*/

package LRACB;

import java.util.ArrayList;



/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ClasificacionJugador implements Comparable {

    private int puntosTotales;
    private int intentosTotales;
    private double minutosTotales;
    private double rendimiento;

    private Jugador jugador;
    private Jornada jornada;


    ClasificacionJugador(Jugador jug, Jornada jor, double minutosTotales,
            int intentosTotales, int puntosTotales){

        this.jugador = jug;
        this.jornada = jor;
        this.minutosTotales = minutosTotales;
        this.intentosTotales = intentosTotales;
        this.puntosTotales = puntosTotales;
    

    }

    double getRendimiento(){
    
        return this.rendimiento; 
    
    }

    public int compareTo(Object o){
    
        ClasificacionJugador cj = (ClasificacionJugador) o;
        
        if (this.rendimiento == cj.getRendimiento()){
            return 0;
        }
        if (this.rendimiento > cj.getRendimiento()){
            return -1;
        }   
    }

    ArrayList obtenerDatosClasificacion(){

        ArrayList datosClasificacion = new ArrayList();
        String nombrej, nomClub, posicion;

            nombrej = (this.jugador).obtenerNombre();
            datosClasificacion.add(nombrej);
            nomClub = (this.jugador).obtenerNombClub();
            datosClasificacion.add(nomClub);
            posicion = (this.jugador).obtenerPosicion();
            datosClasificacion.add(posicion);
            datosClasificacion.add(this.puntosTotales);
            datosClasificacion.add(this.intentosTotales);
            datosClasificacion.add(this.minutosTotales);
            datosClasificacion.add(this.rendimiento);

        return datosClasificacion;

    }

    ArrayList obtenerDatosJornada(){

        ArrayList datosJornada = new ArrayList();
        int numJornada = (this.jornada).getNumero();
        datosJornada.add(numJornada);
        datosJornada.add(this.puntosTotales);
        datosJornada.add(this.intentosTotales);
        datosJornada.add(this.minutosTotales);
        datosJornada.add(this.rendimiento);

        return datosJornada;

    }
    

    
}
