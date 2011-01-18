package LRACB;

import java.util.ArrayList;



/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ClasificacionJugador {

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

    ArrayList obtenerDatosClasificacion(){}

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
